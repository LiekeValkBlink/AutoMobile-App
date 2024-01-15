package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.ReservedCar


object ReservationRepository {
    suspend fun reservedCar(): List<ReservedCar> {
        val response = ApiClient.reservationService.reservedCar().execute().body()
        return response?.data ?: emptyList()
    }
}