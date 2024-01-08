package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.AccountWithProfile
import com.example.automobile.data.models.Profile

/**
 * ProfileRepository connects profile endpoint calls to Retrofit2
 */
object ProfileRepository {
    suspend fun getProfile(): AccountWithProfile? {
        val account = AccountRepository.getAccount() ?: return null

        if (account.userProfileID == null) {
            return AccountWithProfile(account = account)
        }

        val profileResponse = ApiClient.profileService.getProfile(account.userProfileID).execute().body()

        if (profileResponse != null && profileResponse.success && profileResponse.data != null) {
            return AccountWithProfile(
                account = account,
                profile = profileResponse.data
            )
        }

        return AccountWithProfile(account = account)
    }

    suspend fun postProfile(profile: Profile): Boolean {
        val accountId = AuthenticationRepository.getToken()?.subject?.toInt()

        if (accountId == null) {
            return false
        }

        val result = ApiClient.profileService.postProfile(accountId, profile).execute().body()

        return result?.success ?: false
    }
}