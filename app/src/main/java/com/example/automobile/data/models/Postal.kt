package com.example.automobile.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Postal(
    val city: String,
    val street: String,
    val house_number: Int,
    val postcode: String,
    val province: String,
    val latitude: Double,
    val longitude: Double
)
