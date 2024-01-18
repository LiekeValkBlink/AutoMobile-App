package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.automobile.components.H3TextComponent
import com.example.automobile.components.InputTextFieldWithIconComponent
import com.example.automobile.components.PrimaryButtonComponent

import com.example.automobile.components.SearchButtonComponent

import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.LightGrey


@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel) {
    val cars = viewModel.availableCars.observeAsState(initial = emptyList())
    var searchText by remember { mutableStateOf("") }
    val filteredCars = viewModel.filteredCars.observeAsState(initial = emptyList())

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
                    .padding(30.dp, 0.dp),
            ) {
                Column {
                    InputTextFieldWithIconComponent(
                        placeholder = "Search for location...",
                        leadingIcon = Icons.Filled.Search,
                        onValueChange = { newText -> searchText = newText },
                        onSearch = { viewModel.searchCars(searchText) }
                    )

                    SearchButtonComponent(
                        value = stringResource(id = R.string.home_search),
                        onClick = { viewModel.searchCars(searchText)}

                    )
                    PrimaryButtonComponent(
                        value = "Search postal",
                        route = { navController.navigate(route = "add_postal_screen") }
                    )
                }

                Spacer(modifier = Modifier.size(40.dp))

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 60.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        H3TextComponent(
                            value = stringResource(id = R.string.home_available_cars)
                        )
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Outlined.FilterAlt,
                                modifier = Modifier.offset(y = (-9).dp),
                                contentDescription = "Filter",
                                tint = LightGrey

                            )
                        }
                    }


                    Column {
                        val carsToShow = if (searchText.isBlank()) cars.value else filteredCars.value
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

                }
            }
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            BottomNavigationBar(navController)
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfHomeScreen() {
    HomeScreen(navController = rememberNavController(), HomeScreenViewModel())
}