package com.example.automobile.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true)
data class CarAvailability(
    @Json(name = "dateTimeFrom")
    val dateTimeFrom: String,
    @Json(name = "dateTimeUntil")
    val dateTimeUntil: String,
    @Json(name = "location")
    val location: String
)
