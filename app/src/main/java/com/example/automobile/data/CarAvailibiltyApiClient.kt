package com.example.automobile.data

import okhttp3.OkHttpClient
import okhttp3.Request

object CarAvailibiltyApiClient {
    val searchLocation = inputSearchLocation.value
    val pickUpDate = inputPickUpDate.value
    val pickUpTime = inputPickUpTime.value

    val searchURL = "API URL"
    val request = Request.Builder()
        .url(searchURL)
        .build()

    val client = OkHttpClient()
    val call = client.newCall(request)

    val response = call.execute()
    if (response.isSuccessful) {
        val carData = response.body()?.string()
        val cars = parseCarData(carData)

        // Update available cars section with fetched cars
        updateAvailableCarsSection(cars)
    } else {
        if (cars.isEmpty()) {
            // Display message indicating no cars found
            val noCarsFoundMessage = stringResource(id = R.string.home_no_cars_found)
            // Update available cars section with the message
            availableCars += noCarsFoundMessage
        }
    }

}