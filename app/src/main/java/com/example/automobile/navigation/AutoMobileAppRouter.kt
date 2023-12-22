package com.example.automobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.automobile.screens.LoginScreen
import com.example.automobile.screens.SignUpScreen
import com.example.automobile.screens.StartScreen
import com.example.automobile.screens.HomeScreen
import com.example.automobile.screens.FavoritesScreen
import com.example.automobile.screens.MapScreen
import com.example.automobile.screens.NotificationsScreen
import com.example.automobile.screens.ProfileScreen
import com.example.automobile.screens.SignUpViewModel
import com.example.automobile.screens.carscreens.AddNewCarLocation
import com.example.automobile.screens.carscreens.CarsViewModel
import com.example.automobile.screens.mapscreens.*

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start_screen"
    ) {
        composable(route = "start_screen") {
            StartScreen(navController = navController)
        }
        composable(route = "sign_up_screen") {
            SignUpScreen(navController = navController, SignUpViewModel())
        }
        composable(route = "login_screen") {
            LoginScreen(navController = navController)
        }
        composable(route = "home_screen") {
            HomeScreen(navController = navController)
        }
        composable(route = "favorites_screen") {
            FavoritesScreen(navController = navController)
        }
        composable(route = "map_screen") {
            val carsViewModel: CarsViewModel = viewModel()
            com.example.automobile.screens.carscreens.HomeScreen(
                modifier = Modifier,
                navController = navController,
                carsUiState = carsViewModel.carsUiState
            )
        }
        composable(route = "notifications_screen") {
            NotificationsScreen(navController = navController)
        }
        composable(route = "profile_screen") {
            ProfileScreen(navController = navController)
        }
        composable(route = "map_Homescreen") {
            val carsViewModel: CarsViewModel = viewModel()
            GoogleMapView(
                modifier = Modifier,
                carsUiState = carsViewModel.carsUiState,
                navController = navController
            )
        }
        composable(route = "car_edit_screen"){
            AddNewCarLocation()
        }
    }
}