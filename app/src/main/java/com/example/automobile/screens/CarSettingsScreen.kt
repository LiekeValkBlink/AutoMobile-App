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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R

import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent

import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor


import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.services.CarsApi
import com.example.automobile.ui.theme.Red
import kotlinx.coroutines.launch

@Composable
fun CarSettingsScreen(navController: NavController, viewModel: CarSettingsViewModel) {
    var postcode by remember { mutableStateOf("") }
    var huisnummer by remember { mutableStateOf("") }

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
                    .padding(30.dp, 0.dp, 30.dp, 90.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                H2TextComponent(
                    value = if (viewModel.carId != null) stringResource(id = R.string.carSettings_heading_edit) else stringResource(id = R.string.carSettings_heading)
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_carBrand),
                    placeholderValue = stringResource(id = R.string.carSettings_carBrand),
                    value = viewModel.carBrand,
                    onValueChange = { carBrand ->
                        viewModel.updateCarBrand(carBrand)
                    }

                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_vehicleType),
                    placeholderValue = stringResource(id = R.string.carSettings_vehicleType),
                    value = viewModel.vehicleType,
                    onValueChange = { vehicleType ->
                        viewModel.updateVehicleType(vehicleType)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_licencePlate),
                    placeholderValue = stringResource(id = R.string.carSettings_licencePlate),
                    value = viewModel.licencePlate,
                    onValueChange = { licencePlate ->
                        viewModel.updateLicencePlate(licencePlate)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_amountOfPassengers),
                    placeholderValue = stringResource(id = R.string.carSettings_amountOfPassengers),
                    value = viewModel.amountOfPassengers,
                    onValueChange = { amountOfPassengers ->
                        viewModel.updateAmountOfPassengers(amountOfPassengers)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_gearboxType),
                    placeholderValue = stringResource(id = R.string.carSettings_gearboxType),
                    value = viewModel.gearboxType,
                    onValueChange = { gearboxType ->
                        viewModel.updateGearboxType(gearboxType)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_amountOfDoors),
                    placeholderValue = stringResource(id = R.string.carSettings_amountOfDoors),
                    value = viewModel.amountOfDoors,
                    onValueChange = { amountOfDoors ->
                        viewModel.updateAmountOfDoors(amountOfDoors)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_gpsAvailable),
                    placeholderValue = stringResource(id = R.string.carSettings_gpsAvailable),
                    value = viewModel.gpsAvailable,
                    onValueChange = { gpsAvailable ->
                        viewModel.updateGpsAvailable(gpsAvailable)
                    }
                )

                TextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_carPriceAmount),
                    placeholderValue = stringResource(id = R.string.carSettings_carPriceAmount),
                    value = viewModel.carPriceAmount,
                    onValueChange = { carPriceAmount ->
                        viewModel.updateCarPriceAmount(carPriceAmount)
                    }
                )
//added variables for postal api call
                var postalInput by remember { mutableStateOf("") }
                var numberInput by remember { mutableStateOf("") }
                var adresInput by remember { mutableStateOf("") }

                TextInputFieldComponent(
                    value = postalInput,
                    onValueChange = {
                        postalInput = it.uppercase()
                        viewModel.getPostalData(postalInput, numberInput)
                    },
                    labelValue = stringResource(id = R.string.postal)
                )
                TextInputFieldComponent(
                    value = numberInput,
                    onValueChange = {
                        numberInput = it
                        viewModel.getPostalData(postalInput, numberInput)
                    },
                    labelValue = stringResource(id = R.string.number)
                )

//                viewModel.postalData?.let { postal ->
//
//                    Text(text = "${postal.street} ${postal.house_number}", color = Color.White)
//                    Text("Latitude: ${postal.latitude}", color = Color.White)
//                    Text("Longitude: ${postal.longitude}", color = Color.White)
//
//                }

                // create postal to save
                val postal = viewModel.postalData
                val PostalToSave = postal?.let {
                    CarLocation(
                        id = viewModel.carId,
                        postal = it.postcode,
                        latitude = postal.latitude,
                        longitude = postal.longitude,
                        number = postal.house_number.toString()
                    )
                }

                PrimaryButtonComponent(
                    value = if (viewModel.carId == null) stringResource(id = R.string.carSettings_btn) else stringResource(
                        id = R.string.carSettings_btn_edit
                    ),
                    route = { viewModel.viewModelScope.launch{if (PostalToSave != null) {

                        CarsApi.retrofitService.savePostal(12, PostalToSave)
                    }}
                        viewModel.submit(callback = { success ->
                            if (success) {
                                navController.navigate("profile_screen")
                            }
                        })
                    }
                )

                Spacer(modifier = Modifier.size(24.dp))

                if (viewModel.carId != null && viewModel.carId >= 0) {
                    SecondaryButtonComponent(
                        value = stringResource(id = R.string.carSetting_secondary_btn),
                        route = {
                            viewModel.removeCar(callback = { success ->
                                if (success) {
                                    navController.navigate("profile_screen")
                                }
                            })
                        },
                        color = Red )
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
fun DefaultPreviewOfCarSettingsScreen() {
    CarSettingsScreen(navController = rememberNavController(), CarSettingsViewModel())
}