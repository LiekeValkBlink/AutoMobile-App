package com.example.automobile.data.services

import com.example.automobile.data.models.CarAvailability
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface CarAvailabilityService {
    @GET("/carAvailabilities")
    @Headers("Content-Type: application/json")
    fun register(@Body carAvailabilityDate: CarAvailability): Call<Unit>
}