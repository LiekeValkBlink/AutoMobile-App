package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Account

/**
 * AccountRepository connects account endpoint calls to Retrofit2
 */
object AccountRepository {
    fun getAccount(): Account? {
        val accountResponse = ApiClient.accountService.getAccount().execute().body()

        if (accountResponse != null && accountResponse.success && accountResponse.data != null) {
            return accountResponse.data
        }

        return null
    }
}