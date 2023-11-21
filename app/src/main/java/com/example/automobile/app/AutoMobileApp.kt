package com.example.automobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.automobile.navigation.Navigation

@Composable
fun AutoMobileApp() {
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()

        Navigation(navController)
    }
}