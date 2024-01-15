package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AvailableCar
import com.example.automobile.data.models.FoundCars


object HomeScreenRepository {
    suspend fun availableCars(): List<AvailableCar> {
        val response = ApiClient.homeScreenService.availableCars().execute().body()
        return response?.data ?: emptyList()
    }

}
