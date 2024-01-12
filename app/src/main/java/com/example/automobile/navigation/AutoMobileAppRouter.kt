package com.example.automobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.automobile.screens.CarSettingsScreen
import com.example.automobile.screens.CarSettingsViewModel
import com.example.automobile.screens.FavoritesScreen
import com.example.automobile.screens.HomeScreen
import com.example.automobile.screens.LoginScreen
import com.example.automobile.screens.LoginViewModel
import com.example.automobile.screens.NotificationsScreen
import com.example.automobile.screens.ProfileScreen
import com.example.automobile.screens.ProfileSettingsScreen
import com.example.automobile.screens.ProfileSettingsViewModel
import com.example.automobile.screens.ProfileViewModel
import com.example.automobile.screens.SignUpScreen
import com.example.automobile.screens.SignUpViewModel
import com.example.automobile.screens.StartScreen
import com.example.automobile.screens.carscreens.CarsViewModel
import com.example.automobile.screens.mapscreens.GoogleMapView

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start_screen"
    ) {
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
            val carsViewModel:  CarsViewModel = viewModel()
            val CarsUiState = carsViewModel.carsUiState
            GoogleMapView(
//                currentLocation = Location(),
                modifier = Modifier,
                carsUiState = CarsUiState,
                navController = navController,
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
        composable(route = "car_settings_screen") {
            CarSettingsScreen(
                navController = navController,
                viewModel = CarSettingsViewModel()
            )
        }
        composable(
            route = "car_settings_screen/{carId}",
            arguments = listOf(navArgument("carId") { type = NavType.IntType })
        ) {
            backStackEntry ->
                CarSettingsScreen(
                    navController = navController,
                    viewModel = CarSettingsViewModel(backStackEntry.arguments?.getInt("carId") ?: -1)
                )
        }

    }
}