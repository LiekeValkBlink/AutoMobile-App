package com.example.automobile.data.services

import com.example.automobile.data.models.CarsResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeScreenService {
    @GET("/availableCars")
    fun availableCars(): Call<CarsResponse>

//    @GET("/searchCars")
//    fun searchCars(): Call<FoundCars>

}
