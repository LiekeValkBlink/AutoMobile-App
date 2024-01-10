package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AccountWithProfile
import com.example.automobile.data.models.Car
import com.example.automobile.data.models.NewCar

object CarRepository {
    fun getCarsByProfileId(profileId: Int): List<Car> {
        val carsResponse = ApiClient.carService.getCarsByProfileId(profileId).execute().body()

        if (carsResponse != null && carsResponse.success && carsResponse.data != null) {
            return carsResponse.data
        }

        return emptyList()
    }

    fun postCar(car: NewCar): Boolean {
        val account = AccountRepository.getAccount() ?: return false

        if (account.userProfileID == null) {
            return false
        }

        car.userProfileID = account.userProfileID

        val response = ApiClient.carService.postCar(car).execute().body()

        return response != null && response.success && response.data != null
    }

    fun updateCar(car: Car): Boolean {
        val account = AccountRepository.getAccount() ?: return false

        if (account.userProfileID == null) {
            return false
        }

        car.userProfileID = account.userProfileID

        val response = ApiClient.carService.updateCar(car.id, car).execute().body()

        return response != null && response.success && response.data != null
    }

    fun getCar(carId: Int): Car? {
        val carResponse = ApiClient.carService.getCar(carId).execute().body()

        if (carResponse != null && carResponse.success && carResponse.data != null) {
            return carResponse.data
        }

        return null
    }

    fun removeCar(carId: Int): Boolean {
        val response = ApiClient.carService.removeCar(carId).execute().body()

        return response != null && response.success
    }
}