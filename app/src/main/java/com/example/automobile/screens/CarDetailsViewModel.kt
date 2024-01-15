package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.repositories.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CarDetailsViewModel(val carId: Int? = null) : ViewModel() {
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

    var postalUiState: String by mutableStateOf("")
        private set

    var postal by mutableStateOf("")

    var number by mutableStateOf("")
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
//
//        var carLocation: CarLocation
//
//        viewModelScope.launch{
//            val carLocation = viewModelScope.async (Dispatchers.IO){
//                CarsApi.retrofitService.getLocation(id = carId)
//
//            }.await()
//           if(carLocation != null){
//               postal = carLocation.postal
//               number = carLocation.number.toString()
//           }
//        }


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

}