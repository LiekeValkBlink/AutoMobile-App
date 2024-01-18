package com.example.automobile.data

import com.example.automobile.BuildConfig
import com.example.automobile.data.interceptors.auth.AuthInterceptor
import com.example.automobile.data.services.AccountService
import com.example.automobile.data.services.AuthenticationService
import com.example.automobile.data.services.CarDetailsService
import com.example.automobile.data.services.CarService
import com.example.automobile.data.services.HomeScreenService
import com.example.automobile.data.services.ProfileService
import com.example.automobile.data.services.RegistrationService
import com.example.automobile.data.services.ReservationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * ApiClient contains singleton Retrofit2 clients and services for making HTTP calls to the back-end API.
 */

object ApiClient {
    /**
     * Create an OkHttpClient interceptor for logging HTTP requests to Logcat.
     * An interceptor captures an OkHttpClient HTTP request and modifies its configuration
     * before executing it.
     */
    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Create a shared Retrofit builder, which serves as a base for building Retrofit clients with different configurations
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    // Create a Retrofit client that can be used for endpoints that do not require authentication
    private val retrofitNonAuthenticated = retrofitBuilder
        .client(OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        )
        .build()

    // Create a Retrofit client that can be used for endpoints that require authentication
    private val retrofit = retrofitBuilder
        .client(OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
        )
        .build()

    // Create Retrofit2 services based on service interfaces

    val registrationService: RegistrationService = retrofitNonAuthenticated.create(RegistrationService::class.java)
    val authenticationService: AuthenticationService = retrofitNonAuthenticated.create(AuthenticationService::class.java)
    val accountService = retrofit.create(AccountService::class.java)
    val profileService = retrofit.create(ProfileService::class.java)
    val carService = retrofit.create(CarService::class.java)
    val homeScreenService = retrofit.create(HomeScreenService::class.java)
    val carDetailsService = retrofit.create(CarDetailsService::class.java)
    val reservationService = retrofit.create(ReservationService::class.java)
}