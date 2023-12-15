package com.example.automobile.data.repositories

import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Account

/**
 * AuthenticationRepository connects endpoint calls to Retrofit2
 */

object AuthenticationRepository {
    fun register(account: Account) = ApiClient.authenticationService.register(account)
}