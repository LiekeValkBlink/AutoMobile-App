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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.DropdownInputComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun AppSettingsScreen(navController: NavController) {
    Surface {
        Surface (modifier = Modifier
            .fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .background(BackgroundColor),
                verticalArrangement = Arrangement.Top
            ) {
                TopNavigationBar(navController)

                //BodyContent
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(30.dp, 0.dp),
                ) {
                    H2TextComponent(value = "App settings")

                    DropdownInputComponent()
                }
            }

            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                BottomNavigationBar(navController)
            }
        }
    }
}