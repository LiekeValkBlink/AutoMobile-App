package com.example.automobile.data.services

import com.example.automobile.data.models.Postal
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://json.api-postcode.nl"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface PostalService {
    @GET("?postcode=4826NP&number=542")
    suspend fun getPostal(): Postal
}

object PostalApi {
    val retrofitService: PostalService by lazy {
        retrofit.create(PostalService::class.java)
    }
}