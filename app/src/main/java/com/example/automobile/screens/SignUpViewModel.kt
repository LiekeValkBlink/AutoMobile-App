package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.R
import com.example.automobile.data.models.RegistrationData
import com.example.automobile.data.repositories.RegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.apache.commons.validator.routines.EmailValidator

/**
 * connects the ui with the repository
 */

class SignUpViewModel() : ViewModel() {
    var loading by mutableStateOf(false)
        private set

    var formHasErrors by mutableStateOf(true)
        private set

    var email by mutableStateOf("")
        private set

    var emailError by mutableStateOf<Int?>(null)
        private set

    var password by mutableStateOf("")
        private set

    var passwordError by mutableStateOf<Int?>(null)
        private set

    fun updateEmail(input: String) {
        email = input
    }

    fun updatePassword(input: String) {
        password = input
    }

    fun submit() {
        loading = true

        if (formHasErrors) {
            loading = false
            return
        }

        val registrationData = RegistrationData(email, password)

        viewModelScope.launch {
            viewModelScope.async(Dispatchers.IO) {
                RegistrationRepository.register(registrationData)
            }.await()

            loading = false
        }
    }

    fun validateEmail() {
        val emailValidator = EmailValidator.getInstance()

        when {
            email.isBlank() -> emailError = R.string.validation_email_empty
            !emailValidator.isValid(email) -> emailError = R.string.validation_email_invalid
            else -> emailError = null
        }

        updateFormErrorState()
    }

    fun validatePassword() {
        when {
            password.isBlank() -> passwordError = R.string.validation_password_empty
            else -> passwordError = null
        }

        updateFormErrorState()
    }

    private fun updateFormErrorState() {
        formHasErrors = (
            emailError != null ||
            passwordError != null
        )
    }
}