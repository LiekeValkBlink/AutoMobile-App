package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.automobile.data.models.Account
import com.example.automobile.data.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private var loading by mutableStateOf(false)

    var account: Account? by mutableStateOf(null)
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

            if (accountWithProfile?.account != null) {
                account = accountWithProfile.account
            }

            loading = false
        }
    }
}