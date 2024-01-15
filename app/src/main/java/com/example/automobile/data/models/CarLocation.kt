package com.example.automobile.data.models

import kotlinx.serialization.Serializable
//dit gaat fout ??

@Serializable
data class CarLocation(
    val id: Int?,
    val postal: String,
    val latitude: Double,
    val longitude: Double,
    val number: String?
)

@Serializable
data class Location(val latitude: Double, val longitude: Double)

@Serializable
data class SaveCarLocationResponse(
    val success: Boolean,
    val data: String?
)
