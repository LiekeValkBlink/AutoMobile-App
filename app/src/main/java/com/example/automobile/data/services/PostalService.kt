package com.example.automobile.data.services

import com.example.automobile.data.models.Postal
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://json.api-postcode.nl"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface PostalService {
    @Headers("token: d33f51f3-29b5-498e-90d2-95bbf1263140")
    @GET("/")
    suspend fun getPostal(
        @Query("postcode") postcode: String,
        @Query("number") number: String

    ): Postal

}

object PostalApi {
    val retrofitService: PostalService by lazy {
        retrofit.create(PostalService::class.java)
    }
}