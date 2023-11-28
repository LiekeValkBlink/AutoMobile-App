package com.example.automobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.automobile.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoMobileApp() {
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()

        Navigation(navController)
    }
}