package com.example.automobile.data.repositories

import android.content.Context
import android.net.Uri
import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AccountWithProfile
import com.example.automobile.data.models.Profile
import java.io.File
import java.io.FileOutputStream


/**
 * ProfileRepository connects profile endpoint calls to Retrofit2
 */
object ProfileRepository {

    suspend fun getProfile(): AccountWithProfile? {
        val account = AccountRepository.getAccount() ?: return null

        if (account.userProfileID == null) {
            return AccountWithProfile(account = account)
        }

        val profileResponse = ApiClient.profileService.getProfile(account.userProfileID).execute().body()

        if (profileResponse != null && profileResponse.success && profileResponse.data != null) {
            return AccountWithProfile(
                account = account,
                profile = profileResponse.data
            )
        }

        return AccountWithProfile(account = account)
    }

    suspend fun postProfile(profile: Profile): Boolean {
        val accountId = AuthenticationRepository.getToken()?.subject?.toInt()

        if (accountId == null) {
            return false
        }

        val result = ApiClient.profileService.postProfile(accountId, profile).execute().body()

        return result?.success ?: false
    }

    fun saveImageToInternalStorage(context: Context, uri: Uri): Uri? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri)
            val fileName = "profile_picture.jpg"
            val file = File(context.filesDir, fileName)
            val outputStream = FileOutputStream(file)
            inputStream?.copyTo(outputStream)
            Uri.fromFile(file)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}