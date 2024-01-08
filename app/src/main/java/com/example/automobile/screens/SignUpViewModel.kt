package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.RegistrationData
import com.example.automobile.data.repositories.RegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * connects the ui with the repository
 */

class SignUpViewModel() : ViewModel() {
    var loading by mutableStateOf(false)

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        email = input
    }

    fun updatePassword(input: String) {
        password = input
    }

    fun submit() {
        loading = true

        val registrationData = RegistrationData(email, password)

        viewModelScope.launch {
            viewModelScope.async(Dispatchers.IO) {
                RegistrationRepository.register(registrationData)
            }.await()

            loading = false
        }
    }
}