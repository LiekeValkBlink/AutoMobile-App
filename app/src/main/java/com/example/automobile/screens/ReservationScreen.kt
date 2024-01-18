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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.CarComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun ReservationScreen(navController: NavController, viewModel: ReservationViewModel) {
    val cars = viewModel.reservedCar.observeAsState(initial = emptyList())

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
                        .padding(30.dp, 30.dp),
                ) {
                    H2TextComponent(value = "Reservations Screen")
                }

            }



            Column {
                val carsToShow = cars.value
                carsToShow.forEach {car ->
                    CarComponent(
                        carBrand = car.carBrand,
                        licencePlate = car.carLocation,
                        carLocation = car.licencePlate,
                        image = painterResource(id = R.drawable.car_placeholder),
                        amountOfPassengers = car.amountOfPassengers,
                        gearboxType = if (car.automatic) "Automatic" else "Manual",
                        price = car.carPriceAmount,
                        carId = car.id,
                        viewModel = FavoritesViewModel(),
                        onClick = {
                            navController.navigate("car_details_screen/${car.id}")
                        }
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
}