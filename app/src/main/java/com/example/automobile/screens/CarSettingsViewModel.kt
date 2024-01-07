package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        getData()
    }

    private fun getData() {
        loading = true

        viewModelScope.launch {
            loading = false
        }
    }

    fun submit() {
        loading = true

        viewModelScope.launch {
            loading = false
        }
    }
}