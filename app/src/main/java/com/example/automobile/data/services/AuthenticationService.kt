package com.example.automobile.data.services

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body
import com.example.automobile.data.models.AuthCredentials
import com.example.automobile.data.models.AuthResponse
import retrofit2.http.Headers

/**
 * AuthenticationService describes available API endpoints to be called by Retrofit2 for authentication
 */

interface AuthenticationService {
    @POST("/login")
    @Headers("Content-Type: application/json")
    fun login(@Body credentials: AuthCredentials): Call<AuthResponse>
}