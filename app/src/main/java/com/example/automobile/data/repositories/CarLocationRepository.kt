package com.example.automobile.data.repositories


import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.services.CarsApi


interface CarLocationRepository {
    suspend fun getCarLocations() : List<CarLocation>
}

class NetworkCarLocationRepository(): CarLocationRepository{
    override suspend fun getCarLocations(): List<CarLocation> {
        return CarsApi.retrofitService.getCarLocations()
    }
}