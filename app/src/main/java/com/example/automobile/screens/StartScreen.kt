package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.automobile.components.LogoComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.fontFamily

@Composable
fun StartScreen(navController: NavController) {

    Surface (modifier = Modifier
        .background(color = BackgroundColor)
        .fillMaxSize()
        .padding(30.dp, 30.dp, 30.dp, 40.dp)
    ){
        Column (modifier = Modifier
            .background(color = BackgroundColor),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                LogoComponent()
                Text(
                    text = "Fast. Reliable. Durable.",
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

@Preview
@Composable
fun DefaultPreviewOfStartScreen() {
    StartScreen(navController = rememberNavController())
}