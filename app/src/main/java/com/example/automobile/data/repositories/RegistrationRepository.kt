package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.RegistrationData

/**
 * RegistrationRepository connects user registration endpoint calls to Retrofit2
 */
object RegistrationRepository {
    suspend fun register(registrationData: RegistrationData): Unit? {
        return ApiClient.registrationService.register(registrationData).execute().body()
    }
}