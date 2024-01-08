package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.automobile.data.models.Car
import com.example.automobile.data.models.NewCar
import com.example.automobile.data.repositories.CarRepository
import com.example.automobile.data.repositories.RegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CarSettingsViewModel(carId: Int? = null) : ViewModel() {
    var loading by mutableStateOf(false)

    var carBrand by mutableStateOf("")
        private set

    var vehicleType by mutableStateOf("")
        private set

    var licencePlate by mutableStateOf("")
        private set

    var amountOfPassengers by mutableStateOf("")
        private set

    var gearboxType by mutableStateOf("")
        private set

    var carPriceAmount by mutableStateOf("")
        private set

    var amountOfDoors by mutableStateOf("")
        private set

    var gpsAvailable by mutableStateOf("")
        private set

    var carPriceCurrency by mutableStateOf("")
        private set

    fun updateCarBrand(input: String) {
        carBrand = input
    }

    fun updateVehicleType(input: String) {
        vehicleType = input
    }

    fun updateLicencePlate(input: String) {
        licencePlate = input
    }

    fun updateAmountOfPassengers(input: String) {
        amountOfPassengers = input
    }

    fun updateGearboxType(input: String) {
        gearboxType = input
    }

    fun updateCarPriceAmount(input: String) {
        carPriceAmount = input
    }

    fun updateAmountOfDoors(input: String) {
        amountOfDoors = input
    }

    fun updateGpsAvailable(input: String) {
        gpsAvailable = input
    }

    fun updateCarPriceCurrency(input: String) {
        carPriceCurrency = input
    }

    init {
        getData()
    }

    private fun getData() {
        loading = true

        viewModelScope.launch {
            loading = false
        }
    }

    fun submit(callback: ((success: Boolean) -> Unit?)? = null) {
        loading = true

        var success = false

        val car = NewCar(
            carBrand = carBrand,
            amountOfPassengers = amountOfPassengers.toInt(),
            licencePlate = licencePlate,
            vehicleType = vehicleType,
            automatic = gearboxType == "Automatic",
            carPriceAmount = carPriceAmount.toDouble(),
            amountOfDoors = amountOfDoors.toInt(),
            gpsAvailable = gpsAvailable == "Available",
            carPriceCurrency = "EUR",
            userProfileID = -1
        )

        viewModelScope.launch {
            success = viewModelScope.async(Dispatchers.IO) {
                CarRepository.postCar(car)
            }.await()

            if (callback != null) {
                callback(success)
            }

            loading = false
        }
    }
}