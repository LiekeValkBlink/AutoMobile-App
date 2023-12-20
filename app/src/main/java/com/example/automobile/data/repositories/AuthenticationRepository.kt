package com.example.automobile.data.repositories

import com.auth0.android.jwt.JWT
import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AuthCredentials
import com.example.automobile.data.models.AuthResponse

/**
 * AuthenticationRepository connects user authentication endpoint calls to Retrofit2
 */

object AuthenticationRepository {
    suspend fun login(credentials: AuthCredentials): Boolean {
        // Login using authenticationService
        val authResponse: AuthResponse? = ApiClient.authenticationService.login(credentials).execute().body()

        // If a token is present in the response (login is successful), store token in LocalStorageRepository
        if (authResponse != null && authResponse.success && authResponse.data.isNotEmpty()) {
            LocalStorageRepository.savePreference(LocalStorageRepository.Keys.AUTH_JWT, authResponse.data)
            return true
        }

        return false
    }

    // getToken returns a parsed JWT if it is present in LocalStorageRepository
    suspend fun getToken(): JWT? {
        val token: String? = LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.AUTH_JWT)

        if (!token.isNullOrEmpty()) {
            return JWT(token)
        }

        return null
    }
}