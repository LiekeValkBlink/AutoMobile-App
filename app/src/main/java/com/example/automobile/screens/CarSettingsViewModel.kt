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

class CarSettingsViewModel(val carId: Int? = null) : ViewModel() {
    var loading by mutableStateOf(false)

    private var userProfileId by mutableStateOf<Int?>(null)

    var carBrand by mutableStateOf("")
        private set

    var vehicleType by mutableStateOf("")
        private set

    var licencePlate by mutableStateOf("")
        private set

    var carLocation by mutableStateOf("")
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

    init {
        getData()
    }

    private fun getData() {
        loading = true

        if (carId == null || carId < 0) {
            return
        }

        viewModelScope.launch {
            val car = viewModelScope.async(Dispatchers.IO) {
                CarRepository.getCar(carId)
            }.await()

            if (car != null) {
                carBrand = car.carBrand
                vehicleType = car.vehicleType
                licencePlate = car.licencePlate
                carLocation = car.carLocation
                amountOfPassengers = car.amountOfPassengers.toString()
                gearboxType = if (car.automatic) "Automatic" else "Manual"
                carPriceAmount = car.carPriceAmount.toString()
                amountOfDoors = car.amountOfDoors.toString()
                gpsAvailable = if (car.gpsAvailable) "Available" else "Not available"
                userProfileId = car.userProfileID
            }

            loading = false
        }
    }

    fun submit(callback: ((success: Boolean) -> Unit?)? = null) {
        loading = true

        var success = false

        viewModelScope.launch {
            if (carId == null || carId < 0) {
                success = submitNewCar()
            } else {
                success = submitCarUpdate()
            }

            if (callback != null) {
                callback(success)
            }

            loading = false
        }
    }

    fun removeCar(callback: ((success: Boolean) -> Unit?)? = null) {
        loading = true

        var success = false

        viewModelScope.launch {
            if (carId == null || carId < 0) {
                callback?.invoke(false)
                return@launch
            }

            success = viewModelScope.async(Dispatchers.IO) {
                CarRepository.removeCar(carId)
            }.await()

            callback?.invoke(success)

            loading = false
        }
    }

    private suspend fun submitNewCar(): Boolean {
        val car = NewCar(
            carBrand = carBrand,
            amountOfPassengers = amountOfPassengers.toInt(),
            licencePlate = licencePlate,
            carLocation = carLocation,
            vehicleType = vehicleType,
            automatic = gearboxType == "Automatic",
            carPriceAmount = carPriceAmount.toDouble(),
            amountOfDoors = amountOfDoors.toInt(),
            gpsAvailable = gpsAvailable == "Available",
            carPriceCurrency = "EUR",
            userProfileID = -1
        )

        return viewModelScope.async(Dispatchers.IO) {
            CarRepository.postCar(car)
        }.await()
    }

    private suspend fun submitCarUpdate(): Boolean {
        val car = Car(
            id = carId!!,
            carBrand = carBrand,
            amountOfPassengers = amountOfPassengers.toInt(),
            licencePlate = licencePlate,
            carLocation = carLocation,
            vehicleType = vehicleType,
            automatic = gearboxType == "Automatic",
            carPriceAmount = carPriceAmount.toDouble(),
            amountOfDoors = amountOfDoors.toInt(),
            gpsAvailable = gpsAvailable == "Available",
            carPriceCurrency = "EUR",
            userProfileID = userProfileId ?: -1
        )

        return viewModelScope.async(Dispatchers.IO) {
            CarRepository.updateCar(car)
        }.await()
    }
}