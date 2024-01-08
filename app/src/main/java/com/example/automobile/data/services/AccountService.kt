package com.example.automobile.data.services

import com.example.automobile.data.models.APIResponse
import com.example.automobile.data.models.Account
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.GET

/**
 * AccountService describes the account API endpoints to be accessed by Retrofit2
 */
interface AccountService {
    @GET("/me")
    @Headers("Content-Type: application/json")
    fun getAccount(): Call<APIResponse<Account>>
}