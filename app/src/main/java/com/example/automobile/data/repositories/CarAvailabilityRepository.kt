package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient

import com.example.automobile.data.models.CarAvailability

object CarAvailabilityRepository {
    fun register(carAvailability: CarAvailability) = ApiClient.CarAvailabilityService.register(carAvailability)
}