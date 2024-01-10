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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.R
import com.example.automobile.components.DropdownInputComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.ui.theme.Red

@Composable
fun CarSettingsScreen(navController: NavController, viewModel: CarSettingsViewModel) {
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

                PrimaryButtonComponent(
                    value = if (viewModel.carId == null) stringResource(id = R.string.carSettings_btn) else stringResource(
                        id = R.string.carSettings_btn_edit
                    ),
                    route = {
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