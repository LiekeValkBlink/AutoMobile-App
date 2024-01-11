package com.example.automobile.screens.mapscreens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.Postal
import com.example.automobile.data.services.PostalApi
import kotlinx.coroutines.launch


class PostalViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var postalUiState: String by mutableStateOf("")
        private set


    init {
        getPostalInfo()
    }
/// bij de volgende functie moet ik de dynamische gegevens gebruiken
    fun getPostalInfo() {
        val postal = "4826NP"
        val number = "542"
        viewModelScope.launch {
            val listResult = PostalApi.retrofitService.getPostal(postal, number )
            postalUiState = listResult.street
        }
    }
}

class AddPostalViewModel: ViewModel() {
    var postalRepository = PostalApi
    var postalData: Postal? by mutableStateOf(null)
    fun getPostalData(postcode: String, huisnummer: String){
        viewModelScope.launch {
            try {
                postalData = postalRepository.retrofitService.getPostal(postcode, huisnummer)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun SavePostal(postal: Postal){

    }
}