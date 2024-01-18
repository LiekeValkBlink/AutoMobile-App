package com.example.automobile.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.AvailableCar
import com.example.automobile.data.repositories.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeScreenViewModel : ViewModel() {

    val availableCars = liveData(Dispatchers.IO) {
        val response = HomeScreenRepository.availableCars()
        emit(response)
    }


    private val _filteredCars = MutableLiveData<List<AvailableCar>>()
    val filteredCars: LiveData<List<AvailableCar>> = _filteredCars

    fun searchCars(location: String) {
        // was nodig om te kijken waarom die de locatie niet mee kreeg
        // Log.d("HomeScreenViewModel", "Zoeken naar locatie: $location")
        viewModelScope.launch {
            val allCars = availableCars.value ?: emptyList()
            val filteredList = allCars.filter {
                it.carLocation.contains(location, ignoreCase = true)
            }
            _filteredCars.postValue(filteredList)
        }
    }




}
