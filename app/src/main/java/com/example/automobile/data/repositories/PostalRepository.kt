package com.example.automobile.data.repositories

import com.example.automobile.data.models.Postal
import com.example.automobile.data.services.PostalApi

interface PostalRepository {
    suspend fun getPostal() : String
}

class NetworkPostalRepository : PostalRepository{
    override suspend fun getPostal(): String {
        return PostalApi.retrofitService.getPostal()
    }
}