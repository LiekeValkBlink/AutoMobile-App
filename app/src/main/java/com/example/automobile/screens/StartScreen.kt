package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.fontFamily

@Composable
fun StartScreen(navController: NavController) {

    Surface (modifier = Modifier
        .fillMaxSize()
    ){
        Column (modifier = Modifier
            .background(BackgroundColor)
            .padding(30.dp)
        ) {
            Column {
                TopNavigationBar(navController)
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.start_screen_slogan),
                        color = Color.White,
                        lineHeight = 60.sp,
                        fontFamily = fontFamily,
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column {
                    PrimaryButtonComponent(
                        value = stringResource(id = R.string.start_screen_primary_btn),
                        route = { navController.navigate(route = "sign_up_screen") },
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    SecondaryButtonComponent(
                        value = stringResource(id = R.string.start_screen_secondary_btn),
                        route = { navController.navigate(route = "login_screen") },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfStartScreen() {
    StartScreen(navController = rememberNavController())
}