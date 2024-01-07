package com.example.automobile.data.services

import com.example.automobile.data.models.APIResponse
import com.example.automobile.data.models.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CarService {
    @GET("/user/{id}/cars")
    @Headers("Content-Type: application/json")
    fun getCarsByProfileId(@Path("id") profileId: Int): Call<APIResponse<List<Car>>>
}