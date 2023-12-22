package com.example.automobile.screens.carscreens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.repositories.NetworkCarLocationRepository

import kotlinx.coroutines.launch
import java.io.IOException

interface CarsUiState{
    data class Success(val cars: List<CarLocation>) : CarsUiState
    object Error: CarsUiState
    object Loading: CarsUiState
}

class CarsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var carsUiState: CarsUiState by mutableStateOf(CarsUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getCarLocations()
    }



    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getCarLocations() {
        viewModelScope.launch {
            carsUiState = try {
                val CarLocationRepository = NetworkCarLocationRepository()
                val listResult = CarLocationRepository.getCarLocations()
                CarsUiState.Success(listResult)
            }catch (e: IOException){
                CarsUiState.Error
            }
        }
    }
}
