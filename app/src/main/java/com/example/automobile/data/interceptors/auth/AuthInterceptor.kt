package com.example.automobile.data.interceptors.auth

import com.example.automobile.data.repositories.LocalStorageRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Gets token from LocalStorageRepository and adds it to requests as a Bearer token
 */

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String? = runBlocking {
            // Gets the token
            LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.AUTH_JWT)
        }

        val requestBuilder = chain.request().newBuilder()

        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}