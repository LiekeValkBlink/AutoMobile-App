package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.Account
import com.example.automobile.data.models.Car
import com.example.automobile.data.repositories.CarRepository
import com.example.automobile.data.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private var loading by mutableStateOf(false)

    var account: Account? by mutableStateOf(null)
        private set

    var cars: List<Car> by mutableStateOf(emptyList())
        private set

    init {
        getData()
    }

    private fun getData() {
        loading = true

        viewModelScope.launch {
            val accountWithProfile = viewModelScope.async(Dispatchers.IO) {
                ProfileRepository.getProfile()
            }.await()

            if (accountWithProfile?.account == null) {
                loading = false
                return@launch
            }

            account = accountWithProfile.account

            if (accountWithProfile.account.userProfileID == null) {
                loading = false
                return@launch
            }

            val profileCars = viewModelScope.async(Dispatchers.IO) {
                CarRepository.getCarsByProfileId(accountWithProfile.account.userProfileID)
            }.await()

            cars = profileCars

            loading = false
        }
    }
}