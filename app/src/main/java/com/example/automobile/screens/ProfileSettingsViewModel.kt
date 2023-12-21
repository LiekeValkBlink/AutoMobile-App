package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProfileSettingsViewModel : ViewModel() {
    var loading by mutableStateOf(false)

    var firstName by mutableStateOf("")
        private set

    var lastName by mutableStateOf("")
        private set

    var dateOfBirth by mutableStateOf("")
        private set

    var driversLicenceNumber by mutableStateOf("")
        private set

    fun updateFirstName(input: String) {
        firstName = input
    }

    fun updateLastName(input: String) {
        lastName = input
    }

    fun updateDateOfBirth(input: String) {
        dateOfBirth = input
    }

    fun updateDriversLicenceNumber(input: String) {
        driversLicenceNumber = input
    }

    fun getData() {
        viewModelScope.launch {
            val profile = viewModelScope.async(Dispatchers.IO) {
                ProfileRepository.getProfile()
            }.await()

            if (profile != null) {
                firstName = profile.firstName
                lastName = profile.lastName
                dateOfBirth = profile.dateOfBirth
                driversLicenceNumber = profile.driversLicenceNumber.toString()
            }

            loading = false
        }
    }
}