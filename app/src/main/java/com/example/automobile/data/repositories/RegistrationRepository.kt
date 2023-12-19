package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Account

/**
 * RegistrationRepository connects user registration endpoint calls to Retrofit2
 */
object RegistrationRepository {
    fun register(account: Account) = ApiClient.registrationService.register(account)
}