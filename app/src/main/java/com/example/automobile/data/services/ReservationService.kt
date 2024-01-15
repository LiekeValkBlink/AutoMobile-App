package com.example.automobile.data.services

import com.example.automobile.data.models.ReservedResponse
import retrofit2.Call
import retrofit2.http.GET

interface ReservationService {
    @GET("/reservedCar")
    fun reservedCar(): Call<ReservedResponse>
}