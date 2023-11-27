package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.H1TextComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.AnnotatedString
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor


@Composable
fun SignUpScreen(navController: NavHostController) {

    Surface(modifier = Modifier
        .fillMaxSize()
        ) {

        Column (
            modifier = Modifier
                .background(BackgroundColor)
                .padding(30.dp),
        ) {

            Column {
                TopNavigationBar(navController)
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    H1TextComponent(
                        value = stringResource(id = R.string.sign_up_header)
                    )
                }

                Column {
                    PrimaryButtonComponent(
                        value = stringResource(id = R.string.register_button),
                        route = { navController.navigate(route = "login_screen") }
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    AnnotatedString(
                        startValue = stringResource(id = R.string.sign_up_already_an_account),
                        endValue = stringResource(id = R.string.sign_up_login),
                        fontSize = 14,
                        route = { navController.navigate(route = "login_screen") }
                    )
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 0.dp),
            verticalArrangement = Arrangement.Center
        ) {

            TextInputFieldComponent(
               labelValue = stringResource(id = R.string.sign_up_username)
            )

            Spacer(modifier = Modifier.size(8.dp))

            TextInputFieldComponent(
                labelValue = stringResource(id = R.string.sign_up_email)
            )

            Spacer(modifier = Modifier.size(8.dp))

            PasswordInputFieldComponent(
                labelValue = stringResource(id = R.string.sign_up_password)
            )

            Spacer(modifier = Modifier.size(8.dp))

            PasswordInputFieldComponent(
                labelValue = stringResource(id = R.string.sign_up_password_repeat)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen(navController = rememberNavController())
}