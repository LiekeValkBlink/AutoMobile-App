package com.example.automobile.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.Account
import com.example.automobile.data.models.Car
import com.example.automobile.data.repositories.CarRepository
import com.example.automobile.data.repositories.LocalStorageRepository
import com.example.automobile.data.repositories.LocalStorageRepository.context
import com.example.automobile.data.repositories.ProfileRepository
import com.example.automobile.data.repositories.ProfileRepository.saveImageToInternalStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.ref.WeakReference
import java.util.jar.Manifest


class ProfileViewModel : ViewModel() {
    private var loading by mutableStateOf(false)

    var account: Account? by mutableStateOf(null)
        private set

    var cars: List<Car> by mutableStateOf(emptyList())
        private set

    private val _imagaUri = MutableLiveData<Uri?>()
    val imageUri: LiveData<Uri?> = _imagaUri


    init {
        getData()
        val context = LocalStorageRepository.context.get()
        context?.let {
            val savedUri = getImageUriFromStorage(context) // Deze functie haalt de opgeslagen URI op
            savedUri?.let {
                setImageUri(it)
            }
        }

    }

    private fun getData() {
        loading = true

        viewModelScope.launch {
            val accountWithProfile = viewModelScope.async(Dispatchers.IO) {
                ProfileRepository.getProfile()
            }.await()

            if (accountWithProfile?.account == null) {
                loading = false
                return@launch
            }

            account = accountWithProfile.account

            if (accountWithProfile.account.userProfileID == null) {
                loading = false
                return@launch
            }

            val profileCars = viewModelScope.async(Dispatchers.IO) {
                CarRepository.getCarsByProfileId(accountWithProfile.account.userProfileID)
            }.await()

            cars = profileCars

            loading = false
        }
    }

    fun setImageUri(uri: Uri?) {
        _imagaUri.value = uri
    }


    fun handleImageUri(context: Context, uri: Uri) {
        val savedUri = saveImageToInternalStorage(context, uri)
    }

    fun saveBitmapAndGetUri(context: Context, bitmap: Bitmap, fileName: String): Uri? {
        // Create a file in the internal storage
        val file = File(context.filesDir, fileName)

        return try {
            // Compress and write the bitmap to the file
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            }

            // Return the Uri of the file
            Uri.fromFile(file)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun getImageUriFromStorage(context: Context): Uri? {
        val sharedPrefs = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        val uriString = sharedPrefs.getString("profileImageUri", null)
        return if (uriString != null) Uri.parse(uriString) else null
    }

}
