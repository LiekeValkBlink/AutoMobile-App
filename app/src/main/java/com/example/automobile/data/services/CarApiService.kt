package com.example.automobile.data.services

import com.example.automobile.data.models.CarLocation
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8082"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface CarsApiService {
    @GET("carlocations")
    suspend fun getCarLocations() :List<CarLocation>
}

object CarsApi{
    val retrofitService: CarsApiService by lazy {
        retrofit.create(CarsApiService::class.java)
    }
}