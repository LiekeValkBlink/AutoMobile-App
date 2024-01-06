package com.example.automobile.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.json.JSONArray

class HomeScreenViewModel() : ViewModel() {

    fun parseCarData(carData: String?): List<Car> {
        val cars = emptyList<Car>()

        if (carData != null) {
            val jsonObject = JSONArray(carData)
            for (i in 0 until jsonObject.length()) {
                val carInfo = jsonObject.getJSONObject(i)
                val brand = carInfo.getString("brand")
                val model = carInfo.getString("model")
                val price = carInfo.getDouble("price")
                val imageURL = carInfo.getString("imageURL")
                val availability = carInfo.getBoolean("availability")

                val car = Car(brand, model, price, imageURL, availability)
                cars += car
            }
        }

        return cars
    }

    fun updateAvailableCarsSection(cars: List<Car>) {
        // Remove existing cars from the list
        availableCars.clear()

        // Add the fetched cars to the list
        cars.forEach { car ->
            val carComponent = CarComponent(
                carBrand = car.brand,
                price = car.price,
                image = painterResource(id = car.imageURL),
                imageDescription = car.imageDescription
            )
            availableCars += carComponent
        }
    }
}



