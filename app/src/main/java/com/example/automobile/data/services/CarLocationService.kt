package com.example.automobile.data.services

import com.example.automobile.data.models.APIResponse
import com.example.automobile.data.models.CarLocation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface CarLocationService {
    @Headers("Content-Type: application/json")
    @POST("carlocation/{id}")
    suspend fun savePostal(@Path("id") id: Int, @Body postal: CarLocation) : Call<APIResponse<String>>

    @GET("carlocations")
    suspend fun getCarLocations() : Call<APIResponse<List<CarLocation>>>

    @GET("carlocations")
    fun getCarLocs() : Call<APIResponse<List<CarLocation>>>

    @GET("carlocation/{id}")
    suspend fun getLocation(@Path("id") id: Int) : Call<APIResponse<CarLocation>>
}