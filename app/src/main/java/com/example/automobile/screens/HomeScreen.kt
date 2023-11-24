package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun HomeScreen(navController: NavController) {
    Surface (modifier = Modifier
        .background(color = BackgroundColor)
        .fillMaxSize()
        .padding(30.dp, 30.dp, 30.dp, 40.dp)
    ) {
        Text(text = "Halloooo")
    }
}

@Preview
@Composable
fun DefaultPreviewOfHomeScreen() {
    HomeScreen(navController = rememberNavController())
}