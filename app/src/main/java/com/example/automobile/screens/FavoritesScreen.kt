package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H1TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.InputBackgroundColor

@Composable
fun FavoritesScreen(navController: NavController) {
    Surface (modifier = Modifier
        .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .background(InputBackgroundColor)
                .padding(30.dp)
        ){
            H1TextComponent(value = "Favorites Screen")
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopNavigationBar(navController)
            BottomNavigationBar(navController)
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfFavoritesScreen() {
    FavoritesScreen(navController = rememberNavController())
}