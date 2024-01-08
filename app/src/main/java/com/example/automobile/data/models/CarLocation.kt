package com.example.automobile.data.models

import kotlinx.serialization.Serializable
import kotlin.math.*

@Serializable
data class CarLocation(
    val id: Int?,
    val postal: String,
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class Location(val latitude: Double, val longitude: Double)

//functie om de afstand tussen twee locaties te berekenen.
fun haversineDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val R = 6371.0  // Aardstraal in kilometers

    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)

    val a = sin(dLat / 2).pow(2) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return R * c
}