package com.example.automobile.data.repositories

import com.example.automobile.data.models.Postal
import com.example.automobile.data.services.PostalApi

interface PostalRepository {
    suspend fun getPostal() : Postal
}

class NetworkPostalRepository : PostalRepository{
    override suspend fun getPostal(): Postal {
        val postal = ""
        val number = ""
        return PostalApi.retrofitService.getPostal(postal, number)
    }
}