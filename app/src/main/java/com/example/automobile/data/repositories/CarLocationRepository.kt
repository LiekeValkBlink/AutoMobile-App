package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.CarLocation

object CarLocationRepository {
    suspend fun getCarLocations(): List<CarLocation> {
        val result = ApiClient.carLocationService.getCarLocations().execute().body()

        if (result != null && result.success && result.data != null) {
            return result.data
        }

        return emptyList()
    }

    suspend fun savePostal(id: Int, postal: CarLocation): Boolean {
        val result = ApiClient.carLocationService.savePostal(id, postal).execute().body()

        return result != null && result.success
    }
}