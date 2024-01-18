package com.example.automobile.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CarLocation(
    val id: Int?,
    val postal: String,
    val latitude: Double,
    val longitude: Double,
    val number: String?,
//    val street: String,
//    val city: String,
//    val province: String
)

@Serializable
data class Location(val latitude: Double, val longitude: Double)

@Serializable
data class SaveCarLocationResponse(
    val success: Boolean,
    val data: String?
)
