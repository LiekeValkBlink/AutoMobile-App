package com.example.automobile.data.models

import com.squareup.moshi.Json

data class APIResponse<T>(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "data")
    val data: T?
)
