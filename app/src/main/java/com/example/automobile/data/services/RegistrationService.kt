package com.example.automobile.data.services

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body
import com.example.automobile.data.models.RegistrationData
import retrofit2.http.Headers

/**
 * RegistrationService describes available API endpoints to be called by Retrofit2 for user registration
 */

interface RegistrationService {
    @POST("/register")
    @Headers("Content-Type: application/json")
    fun register(@Body registrationData: RegistrationData): Call<Unit>
}