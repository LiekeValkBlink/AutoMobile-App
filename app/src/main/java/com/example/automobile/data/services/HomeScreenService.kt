package com.example.automobile.data.services

import com.example.automobile.data.models.CarsResponse
import com.example.automobile.data.models.FoundCars
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeScreenService {
    @GET("/availableCars")
    fun availableCars(): Call<CarsResponse>

//    @GET("/searchCars")
//    fun searchCars(): Call<FoundCars>

}
