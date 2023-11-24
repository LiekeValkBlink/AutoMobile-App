package com.example.automobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.automobile.screens.LoginScreen
import com.example.automobile.screens.SignUpScreen
import com.example.automobile.screens.StartScreen
import com.example.automobile.screens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start_screen"
    ){
        composable(route = "start_screen") {
            StartScreen(navController = navController)
        }
        composable(route = "sign_up_screen") {
            SignUpScreen(navController = navController)
        }
        composable(route = "login_screen") {
            LoginScreen(navController = navController)
        }
        composable(route = "home_screen") {
            HomeScreen(navController = navController)
        }
    }
}