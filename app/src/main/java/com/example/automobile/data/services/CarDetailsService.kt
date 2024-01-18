package com.example.automobile.data.services


import com.example.automobile.data.models.ResponseCall
import retrofit2.Response
import retrofit2.http.PATCH
import retrofit2.http.Path

interface CarDetailsService {
    @PATCH("car/reserve/{id}")
    suspend fun reserveCar(@Path("id") carId: Int): Response<ResponseCall>
}