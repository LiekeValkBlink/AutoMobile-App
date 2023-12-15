package com.example.automobile.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Models translates an interface used by Retrofit2 for request and response bodies
 */

@JsonClass (generateAdapter = true)
data class Account(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)
