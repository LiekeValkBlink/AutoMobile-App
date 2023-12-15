package com.example.automobile.screens

import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.H1TextComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.PasswordInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.AnnotatedString
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.data.ApiClient
import com.example.automobile.data.models.Account
import com.example.automobile.data.repositories.AuthenticationRepository
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.fontFamily
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread


@Composable
fun SignUpScreen(navController: NavHostController) {

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
                    .padding(30.dp, 20.dp, 30.dp, 40.dp),
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
                        route = {
                            val account: Account = Account("AppTest", "test")

                            thread {
                                AuthenticationRepository.register(account).enqueue(object: Callback<Unit> {
                                    override fun onResponse(
                                        call: Call<Unit>,
                                        response: Response<Unit>
                                    ) {
                                        Log.d("Response", "${response.body()}")
                                    }

                                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                                        Log.d("Response", "FAIL")
                                    }
                                })
                            }
                        }
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