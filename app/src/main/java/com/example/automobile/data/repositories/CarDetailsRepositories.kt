package com.example.automobile.data.repositories

import android.annotation.SuppressLint
import com.example.automobile.data.ApiClient


object CarDetailsRepositories {
    @SuppressLint("SuspiciousIndentation")
    suspend fun reserveCar(carId: Int): Result<Boolean> {
        return try {
            val response = ApiClient.carDetailsService.reserveCar(carId)
                if (response.isSuccessful && response.body()?.success == true) {
                    Result.success(true)
                }else {
                    Result.failure(Exception("Failed to reserve car"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }


