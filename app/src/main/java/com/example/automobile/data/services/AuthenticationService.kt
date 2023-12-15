package com.example.automobile.data.services

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body
import com.example.automobile.data.models.Account
import retrofit2.http.Headers

/**
 * AuthenticationService describes available api endpoints to be called by Retrofit2
 */

interface AuthenticationService {
    @POST("/register")
    @Headers("Content-Type: application/json")
    fun register(@Body accountData: Account): Call<Unit>
}