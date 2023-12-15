package com.example.automobile.data

import com.example.automobile.BuildConfig
import com.example.automobile.data.services.AuthenticationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ApiClient contains a singleton Retrofit2 client
 */

object ApiClient {
    // an interceptor captures an http request and logs information about it
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    // add interceptor to okHttpClient
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    // build a new retrofit client (to use retrofit)
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // make authentication service endpoints callable by retrofit
    val authenticationService: AuthenticationService by lazy {
        retrofit.create(AuthenticationService::class.java)
    }
}