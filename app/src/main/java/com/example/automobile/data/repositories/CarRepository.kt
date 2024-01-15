package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AccountWithProfile
import com.example.automobile.data.models.Car
import com.example.automobile.data.models.NewCar
import kotlinx.coroutines.runBlocking

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

    suspend fun favoriteCar(carId: Int): Boolean {
        var newPref = mutableSetOf<String>()
        val pref = LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.FAVORITES)

        if (pref != null) {
            newPref = pref.toMutableSet()
        }

        newPref.add(carId.toString())
        LocalStorageRepository.savePreference(LocalStorageRepository.Keys.FAVORITES, newPref)

        return true
    }

    suspend fun unfavoriteCar(carId: Int): Boolean {
        var newPref = mutableSetOf<String>()
        val pref = LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.FAVORITES)

        if (pref != null) {
            newPref = pref.toMutableSet()
        }

        newPref.remove(carId.toString())
        LocalStorageRepository.savePreference(LocalStorageRepository.Keys.FAVORITES, newPref)

        return true
    }

    suspend fun isCarFavorited(carId: Int): Boolean {
        val pref = LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.FAVORITES)

        return pref?.contains(carId.toString()) ?: false
    }

    suspend fun toggleFavoriteCar(carId: Int): Boolean {
        var result = false

        runBlocking {
            if (isCarFavorited(carId)) {
                result = unfavoriteCar(carId)
            } else {
                result = favoriteCar(carId)
            }
        }

        return result
    }

    suspend fun getFavoriteCars(): List<Int> {
        val pref = LocalStorageRepository.loadPreference(LocalStorageRepository.Keys.FAVORITES)

        return pref?.map { value -> value.toInt() } ?: emptyList()
    }
}