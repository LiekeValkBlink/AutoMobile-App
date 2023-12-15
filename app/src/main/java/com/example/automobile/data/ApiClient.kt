package com.example.automobile.data

import com.example.automobile.BuildConfig
import com.example.automobile.data.services.AuthenticationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authenticationService: AuthenticationService by lazy {
        retrofit.create(AuthenticationService::class.java)
    }
}