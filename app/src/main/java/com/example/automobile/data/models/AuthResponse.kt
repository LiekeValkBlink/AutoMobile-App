package com.example.automobile.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse (
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "data")
    val data: String
)