package com.example.automobile.app

import com.example.automobile.data.models.CarLocation
import kotlin.math.*
import kotlin.random.Random

data class Location(val latitude: Double, val longitude: Double)

fun generateDummyData(numWithin1km: Int, numBetween2: Int, centerLocation: Location): List<CarLocation> {
    val dummyData = mutableListOf<CarLocation>()

    // Genereren van 5 locaties binnen 5 km van het centrum
    repeat(numWithin1km) {
        val latOffset = randomUniform(-0.009, 0.009)
        val lonOffset = randomUniform(-0.009, 0.009)
        val location = CarLocation(null, "", centerLocation.latitude + latOffset, centerLocation.longitude + lonOffset, null)
        dummyData.add(location)
    }

    // Genereren van 15 locaties tussen 5 en 15 km van het centrum
    repeat(numBetween2) {
        val distance = randomUniform(5.0, 15.0)
        val angle = randomUniform(0.0, 360.0)
        val latOffset = distance * 0.008983 * sin(Math.toRadians(angle))
        val lonOffset = distance * 0.008983 * cos(Math.toRadians(angle))
        val location = CarLocation(null, "", centerLocation.latitude + latOffset, centerLocation.longitude + lonOffset, null)
        dummyData.add(location)
    }

    return dummyData
}

fun randomUniform(min: Double, max: Double): Double {
    return min + (max - min) * Random.nextDouble()
}

fun main() {
    val centerLocation = Location(51.6466733, 4.6023077)
    val dummyData = generateDummyData(1, 15, centerLocation)

    dummyData.forEachIndexed { index, location ->
        println("Location $index: Latitude: ${location.latitude}, Longitude: ${location.longitude}")
    }
}
