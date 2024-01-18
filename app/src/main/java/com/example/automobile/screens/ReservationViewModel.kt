package com.example.automobile.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.automobile.data.repositories.ReservationRepository
import kotlinx.coroutines.Dispatchers

class ReservationViewModel : ViewModel(){
    val reservedCar = liveData(Dispatchers.IO) {
        val response = ReservationRepository.reservedCar()
        emit(response)
    }


}