package com.example.automobile.data.services

import com.example.automobile.data.models.APIResponse
import com.example.automobile.data.models.Profile
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * ProfileService describes the profile API endpoints to be accessed by Retrofit2
 */
interface ProfileService {
    @GET("/user/{id}")
    @Headers("Content-Type: application/json")
    fun getProfile(@Path("id") id: Int): Call<APIResponse<Profile>>
}