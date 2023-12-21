package com.example.automobile.data.repositories

import android.util.Log
import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Profile

/**
 * ProfileRepository connects profile endpoint calls to Retrofit2
 */
object ProfileRepository {
    suspend fun getProfile(): Profile? {
        val account = AccountRepository.getAccount() ?: return null

        if (account.userProfileID == null) {
            return null
        }

        val profileResponse = ApiClient.profileService.getProfile(account.userProfileID).execute().body()

        if (profileResponse != null && profileResponse.success && profileResponse.data != null) {
            return profileResponse.data
        }

        return null
    }
}