package com.example.automobile.screens

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.automobile.components.H1TextComponent

@Composable
fun ProfileScreen(navController: NavController) {
    Surface {
        H1TextComponent(value = "Profile Screen")
    }
}