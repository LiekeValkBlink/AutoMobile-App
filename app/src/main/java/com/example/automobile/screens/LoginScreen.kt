package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.HeadingTextComponent
import com.example.automobile.components.LogoComponent
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@Composable
fun LoginScreen(navController: NavController) {
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
                HeadingTextComponent(
                    value = stringResource(id = R.string.login_screen_heading)
                )
            }

            Column {
                PrimaryButtonComponent(
                    value = stringResource(id = R.string.login_screen_btn),
                    route = { navController.navigate(route = "home_screen") },
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Forgot your password?",
                    textAlign = TextAlign.Center,
                    color = White,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Column (verticalArrangement = Arrangement.Center){
            TextInputFieldComponent(
                labelValue = stringResource(id = R.string.login_screen_email)
            )
            Spacer(modifier = Modifier.size(8.dp))
            PasswordInputFieldComponent(
                labelValue = stringResource(id = R.string.login_screen_password)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen(navController = rememberNavController())
}