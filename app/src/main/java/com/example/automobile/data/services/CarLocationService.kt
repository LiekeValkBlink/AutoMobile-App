package com.example.automobile.data.services

import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.models.SaveCarLocationResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

val json = Json {
    ignoreUnknownKeys = true
}

private const val BASE_URL = "http://10.0.2.2:8082"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface CarsApiService {
    @GET("carlocations")
    suspend fun getCarLocations() :List<CarLocation>

    @GET("carlocations")
    fun getCarLocs() : List<CarLocation>

    @GET("carlocation/{id}")
    suspend fun getLocation(@Path("id") id: Int) : CarLocation

    @Headers("Content-Type: application/json")
    @POST("carlocation/{id}")
    suspend fun savePostal(@Path("id") id: Int, @Body postal: CarLocation) : Response<SaveCarLocationResponse>

}

object CarsApi{
    val retrofitService: CarsApiService by lazy {
        retrofit.create(CarsApiService::class.java)
    }
}