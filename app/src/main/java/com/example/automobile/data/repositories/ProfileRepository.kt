package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Account

/**
 * ProfileRepository connects profile endpoint calls to Retrofit2
 */
object ProfileRepository {
    fun getProfile(id: Int) = ApiClient.profileService.getProfile(id)
}