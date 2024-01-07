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
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.AnnotatedString
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor


@Composable
fun SignUpScreen(navController: NavHostController, viewModel: SignUpViewModel) {

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
                        value = stringResource(id = R.string.signUp_header)
                    )
                }

                if (viewModel.loading) {
                    CircularProgressIndicator()
                }

                Column {
                    PrimaryButtonComponent(
                        value = stringResource(id = R.string.signUp_submit),
                        route = {
                            viewModel.submit()
                        }
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    AnnotatedString(
                        startValue = stringResource(id = R.string.signUp_already_an_account),
                        endValue = stringResource(id = R.string.signUp_login),
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
                labelValue = stringResource(id = R.string.signUp_email),
                placeholderValue = stringResource(id = R.string.signUp_email),
                value = viewModel.email,
                onValueChange = { email -> viewModel.updateEmail(email) }
            )
            Spacer(modifier = Modifier.size(12.dp))

            PasswordInputFieldComponent(
                labelValue = stringResource(id = R.string.signUp_password),
                placeholderValue = stringResource(id = R.string.signUp_password),
                value = viewModel.password,
                onValueChange = { password -> viewModel.updatePassword(password) }
            )

            Spacer(modifier = Modifier.size(12.dp))

            PasswordInputFieldComponent(
                labelValue = stringResource(id = R.string.signUp_password_repeat),
                placeholderValue = stringResource(id = R.string.signUp_password_repeat)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen(navController = rememberNavController(), SignUpViewModel())
}