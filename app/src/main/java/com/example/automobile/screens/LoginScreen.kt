package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.AnnotatedString
import com.example.automobile.components.H1TextComponent
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
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
                    .padding(30.dp, 30.dp, 30.dp, 30.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    H1TextComponent(
                        value = stringResource(id = R.string.login_heading)
                    )
                }

                Column {
                    PrimaryButtonComponent(
                        value = stringResource(id = R.string.login_btn),
                        route = {
                            viewModel.submit(callback = { result ->
                                if (result) {
                                    navController.navigate(route = "home_screen")
                                }
                            })
                        }
                    )
                    if (viewModel.loading) {
                        CircularProgressIndicator()
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    AnnotatedString(
                        startValue = stringResource(id = R.string.login_forgot_password),
                        endValue = stringResource(id = R.string.login_reset_password),
                        fontSize = 14,
                        route = { }
                    )
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(30.dp, 0.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TextInputFieldComponent (
                labelValue = stringResource(id = R.string.login_email_label),
                placeholderValue = stringResource(id = R.string.login_email_placeholder),
                value = viewModel.email,
                onValueChange = { email -> viewModel.updateEmail(email) }
            )

            PasswordInputFieldComponent (
                labelValue = stringResource(id = R.string.login_password),
                value = viewModel.password,
                onValueChange = { password -> viewModel.updatePassword(password) }
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen(navController = rememberNavController(), LoginViewModel())
}