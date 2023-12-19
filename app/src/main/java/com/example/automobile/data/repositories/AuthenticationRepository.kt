package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AuthCredentials
import com.example.automobile.data.models.AuthResponse

/**
 * AuthenticationRepository connects user authentication endpoint calls to Retrofit2
 */

object AuthenticationRepository {
    suspend fun login(credentials: AuthCredentials): Boolean {
        val authResponse: AuthResponse? = ApiClient.authenticationService.login(credentials).execute().body()

        if (authResponse != null && authResponse.success && authResponse.data.isNotEmpty()) {
            LocalStorageRepository.savePreference(LocalStorageRepository.Keys.AUTH_JWT, authResponse.data)
            return true
        }

        return false
    }

    suspend fun isTokenPresent(): Boolean {
        return !(LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.AUTH_JWT).isNullOrEmpty())
    }
}