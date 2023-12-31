package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.AuthCredentials
import com.example.automobile.data.repositories.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * loginViewModel connects the LoginScreen with AuthenticationRepository
 */

class LoginViewModel : ViewModel() {
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

    fun submit(callback: (result: Boolean) -> Unit) {
        loading = true

        val authCredentials = AuthCredentials(email, password)

        viewModelScope.launch {
            val result = viewModelScope.async(Dispatchers.IO) {
                AuthenticationRepository.login(authCredentials)
            }.await()

            loading = false

            callback(result)
        }
    }
}
