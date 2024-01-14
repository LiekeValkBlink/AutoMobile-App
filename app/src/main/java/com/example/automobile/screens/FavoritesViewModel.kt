package com.example.automobile.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {
    private val _favoriteCars = MutableLiveData<Set<Int>>(setOf())
    val favoriteCars: LiveData<Set<Int>> = _favoriteCars

    fun toggleFavorite(carId: Int) {
        val currentFavorites = _favoriteCars.value ?: setOf()
        if (currentFavorites.contains(carId)) {
            _favoriteCars.value = currentFavorites - carId
        } else {
            _favoriteCars.value = currentFavorites + carId
        }
    }

    fun isFavorite(carId: Int): Boolean {
        return _favoriteCars.value?.contains(carId) ?: false
    }
}