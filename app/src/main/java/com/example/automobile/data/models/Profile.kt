package com.example.automobile.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * The Profile model is a data class that is used to serialize and deserialize
 * profile data when communicating with the API
 */
@JsonClass (generateAdapter = true)
data class Profile(
    @Json(name = "firstName")
    var firstName: String,
    @Json(name = "lastName")
    var lastName: String,
    @Json(name = "dateOfBirth")
    var dateOfBirth: String,
    @Json(name = "driversLicenceNumber")
    var driversLicenceNumber: Int
)
