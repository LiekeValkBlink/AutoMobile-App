package com.example.automobile.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CarLocation(
    val id: Int?,
    val postal: String,
    val latitude: Double,
    val longitude: Double
)
