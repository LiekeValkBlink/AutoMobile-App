package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.HeadingTextComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.LogoComponent
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily


@Composable
fun SignUpScreen(navController: NavHostController) {
    Surface(modifier = Modifier
        .background(color = BackgroundColor)
        .fillMaxSize()
        .padding(30.dp, 30.dp, 30.dp, 40.dp)
        ) {

        Column (modifier = Modifier
                .background(color = BackgroundColor),
                verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                LogoComponent()

                HeadingTextComponent(
                    value = stringResource(id = R.string.sign_up_header)
                )
            }

            Column {
                PrimaryButtonComponent(
                    value = stringResource(id = R.string.register_button),
                    route = { navController.navigate(route = "sign_up_screen") }
                )
                Spacer(modifier = Modifier.size(20.dp))
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.sign_up_login)),
                    onClick = { navController.navigate(route = "login_screen") }

                )
            }
        }

        Column (verticalArrangement = Arrangement.Center) {
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