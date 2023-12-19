package com.example.automobile.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.automobile.data.models.Account
import com.example.automobile.data.repositories.RegistrationRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

/**
 * connects the ui with the repository
 */

class SignUpViewModel() : ViewModel() {
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
        val account = Account(email, password)

        thread {
            RegistrationRepository.register(account).enqueue(object: Callback<Unit> {
                override fun onResponse(
                    call: Call<Unit>,
                    response: Response<Unit>
                ) {
                    Log.d("Response", "${response.body()}")
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("Response", "FAIL")
                }
            })
        }
    }
}