package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Car

object CarRepository {
    fun getCarsByProfileId(profileId: Int): List<Car> {
        val carsResponse = ApiClient.carService.getCarsByProfileId(profileId).execute().body()

        if (carsResponse != null && carsResponse.success && carsResponse.data != null) {
            return carsResponse.data
        }

        return emptyList()
    }
}