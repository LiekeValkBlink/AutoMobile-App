package com.example.automobile.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * The Account model is a data class that is used to serialize and deserialize
 * account data when communicating with the API
 */
@JsonClass(generateAdapter = true)
data class Account(
    @Json(name = "id")
    val id: Int,
    @Json(name = "email")
    val email: String,
    @Json(name = "userProfileID")
    val userProfileID: Int?
)
