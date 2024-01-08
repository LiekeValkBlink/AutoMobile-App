package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.CarComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.SmallPrimaryButtonComponent
import com.example.automobile.components.ProfileComponent
import com.example.automobile.components.TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel) {
    val account = viewModel.account

    Surface (modifier = Modifier
        .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .background(BackgroundColor)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            TopNavigationBar(navController)

            //BodyContent
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(30.dp, 0.dp, 30.dp, 90.dp),
            ) {
                H2TextComponent(value = stringResource(id = R.string.profile))

                ProfileComponent(
                    profileImage = painterResource(id = R.drawable.profile_placeholder),
                    username = account?.email ?: "",
                    email = account?.email ?: ""
                )

                SmallPrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_complete_profile),
                    route = { navController.navigate("profile_settings_screen") }
                )

                Spacer(modifier = Modifier.size(40.dp))

                H2TextComponent(value = stringResource(id = R.string.profile_your_cars))

                for (car in viewModel.cars) {
                    CarComponent(
                        carBrand = car.carBrand + " " + car.vehicleType,
                        licencePlate = car.licencePlate,
                        image = painterResource(id = R.drawable.car_placeholder),
                        amountOfPassengers = car.amountOfPassengers,
                        gearboxType = if (car.automatic) "Automatic" else "Manual",
                        price = car.carPriceAmount,
                        isOwnCar = true
                    )
                }

                SmallPrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_add_car),
                    route = { navController.navigate("car_settings_screen") }
                )
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

@Preview
@Composable
fun DefaultPreviewOfProfileScreen() {
    ProfileScreen(navController = rememberNavController(), ProfileViewModel())
}