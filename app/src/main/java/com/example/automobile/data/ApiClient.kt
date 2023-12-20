package com.example.automobile.data

import com.example.automobile.BuildConfig
import com.example.automobile.data.interceptors.auth.AuthInterceptor
import com.example.automobile.data.services.AuthenticationService
import com.example.automobile.data.services.RegistrationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ApiClient contains singleton Retrofit2 clients and services for making HTTP calls to the back-end API.
 */

object ApiClient {
    // an interceptor captures an http request and logs information about it
    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

    // declare services callable by retrofit
    lateinit var registrationService: RegistrationService
    lateinit var authenticationService: AuthenticationService

    fun init() {
        // Create a shared Retrofit builder, which serves as a base for building Retrofit clients with different configurations
        val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        // Create a Retrofit client that can be used for endpoints that do not require authentication
        val retrofitNonAuthenticated = retrofitBuilder
            .client(OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            )
            .build()

        // Create a Retrofit client that can be used for endpoints that require authentication
        val retrofit = retrofitBuilder
            .client(OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor())
                .addInterceptor(loggingInterceptor)
                .build()
            )
            .build()

        // initialize endpoints for declared services
        registrationService = retrofitNonAuthenticated.create(RegistrationService::class.java)
        authenticationService = retrofitNonAuthenticated.create(AuthenticationService::class.java)
    }
}