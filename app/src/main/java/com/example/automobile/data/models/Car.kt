package com.example.automobile.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * The Car model is a data class that is used to serialize and deserialize
 * car data when communicating with the API
 */
@JsonClass(generateAdapter = true)
data class Car(
    @Json(name = "id")
    val id: Int,
    @Json(name = "licencePlate")
    var licencePlate: String,
    @Json(name = "carBrand")
    var carBrand: String,
    @Json(name = "vehicleType")
    var vehicleType: String,
    @Json(name = "amountOfPassengers")
    var amountOfPassengers: Int,
    @Json(name = "amountOfDoors")
    var amountOfDoors: Int,
    @Json(name = "automatic")
    var automatic: Boolean,
    @Json(name = "gpsAvailable")
    var gpsAvailable: Boolean,
    @Json(name = "carPriceAmount")
    var carPriceAmount: Double,
    @Json(name = "carPriceCurrency")
    var carPriceCurrency: String,
    @Json(name = "userProfileID")
    var userProfileID: Int,
    @Json(name = "carLocation")
    var carLocation: String,
) {

}

@JsonClass(generateAdapter = true)
data class NewCar(
    @Json(name = "licencePlate")
    var licencePlate: String,
    @Json(name = "carBrand")
    var carBrand: String,
    @Json(name = "vehicleType")
    var vehicleType: String,
    @Json(name = "amountOfPassengers")
    var amountOfPassengers: Int,
    @Json(name = "amountOfDoors")
    var amountOfDoors: Int,
    @Json(name = "automatic")
    var automatic: Boolean,
    @Json(name = "gpsAvailable")
    var gpsAvailable: Boolean,
    @Json(name = "carPriceAmount")
    var carPriceAmount: Double,
    @Json(name = "carPriceCurrency")
    var carPriceCurrency: String,
    @Json(name = "userProfileID")
    var userProfileID: Int,
    @Json(name = "carLocation")
    var carLocation: String,
)

@JsonClass(generateAdapter = true)
data class AvailableCar(
    @Json(name = "licencePlate")
    var licencePlate: String,
    @Json(name = "carBrand")
    var carBrand: String,
    @Json(name = "carPriceAmount")
    var carPriceAmount: Double,
    @Json(name = "carAvailable")
    var carAvailable: Boolean,
    @Json(name = "carLocation")
    var carLocation: String,
    @Json(name = "automatic")
    var automatic: Boolean,
    @Json(name = "amountOfPassengers")
    var amountOfPassengers: Int,
    @Json(name = "id")
    val id: Int,
)

data class CarsResponse(
    val success: Boolean,
    val data: List<AvailableCar>
)

@JsonClass(generateAdapter = true)
data class SearchedCars(
    @Json(name = "licencePlate")
    var licencePlate: String,
    @Json(name = "carBrand")
    var carBrand: String,
    @Json(name = "carPriceAmount")
    var carPriceAmount: Double,
    @Json(name = "carAvailable")
    var carAvailable: Boolean,
    @Json(name = "carLocation")
    var carLocation: String,
    @Json(name = "automatic")
    var automatic: Boolean,
    @Json(name = "amountOfPassengers")
    var amountOfPassengers: Int,
)

data class ResponseCall(
    val success: Boolean,
    val data: List<AvailableCar>
)

@JsonClass(generateAdapter = true)
data class ReservedCar(
    @Json(name = "licencePlate")
    var licencePlate: String,
    @Json(name = "carBrand")
    var carBrand: String,
    @Json(name = "carPriceAmount")
    var carPriceAmount: Double,
    @Json(name = "carAvailable")
    var carAvailable: Boolean,
    @Json(name = "carLocation")
    var carLocation: String,
    @Json(name = "automatic")
    var automatic: Boolean,
    @Json(name = "amountOfPassengers")
    var amountOfPassengers: Int,
    @Json(name = "id")
    val id: Int,
)

data class ReservedResponse(
    val success: Boolean,
    val data: List<ReservedCar>
)
