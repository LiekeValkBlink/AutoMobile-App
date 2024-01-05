package com.example.automobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.automobile.screens.LoginScreen
import com.example.automobile.screens.SignUpScreen
import com.example.automobile.screens.StartScreen
import com.example.automobile.screens.HomeScreen
import com.example.automobile.screens.FavoritesScreen
import com.example.automobile.screens.LoginViewModel
import com.example.automobile.screens.MapScreen
import com.example.automobile.screens.NotificationsScreen
import com.example.automobile.screens.ProfileScreen
import com.example.automobile.screens.ProfileSettingsScreen
import com.example.automobile.screens.ProfileSettingsViewModel
import com.example.automobile.screens.ProfileViewModel
import com.example.automobile.screens.SignUpViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start_screen"
    ){
        composable(route = "start_screen") {
            StartScreen(
                navController = navController
            )
        }
        composable(route = "sign_up_screen") {
            SignUpScreen(
                navController = navController,
                viewModel = SignUpViewModel()
            )
        }
        composable(route = "login_screen") {
            LoginScreen(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }
        composable(route = "home_screen") {
            HomeScreen(
                navController = navController
            )
        }
        composable(route = "favorites_screen") {
            FavoritesScreen(
                navController = navController
            )
        }
        composable(route = "map_screen") {
            MapScreen(
                navController = navController
            )
        }
        composable(route = "notifications_screen") {
            NotificationsScreen(
                navController = navController
            )
        }
        composable(route = "profile_screen") {
            ProfileScreen(
                navController = navController,
                viewModel = ProfileViewModel()
            )
        }
        composable(route = "profile_settings_screen") {
            ProfileSettingsScreen(
                navController = navController,
                viewModel = ProfileSettingsViewModel()
            )
        }
    }
}