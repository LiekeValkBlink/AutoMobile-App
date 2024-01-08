package com.example.automobile.data.services

import com.example.automobile.data.models.APIResponse
import com.example.automobile.data.models.Car
import com.example.automobile.data.models.NewCar
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface CarService {
    @GET("/user/{id}/cars")
    @Headers("Content-Type: application/json")
    fun getCarsByProfileId(@Path("id") profileId: Int): Call<APIResponse<List<Car>>>

    @POST("/car")
    @Headers("Content-Type: application/json")
    fun postCar(@Body car: NewCar): Call<APIResponse<String>>
}