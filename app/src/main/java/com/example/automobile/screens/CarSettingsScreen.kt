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
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SmallPrimaryButtonComponent
import com.example.automobile.components.SmallTextInputFieldComponent

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
                    .padding(30.dp, 0.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                H2TextComponent(
                    value = stringResource(id = R.string.carSettings_heading)
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_carBrand),
                    placeholderValue = stringResource(id = R.string.carSettings_carBrand),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_vehicleType),
                    placeholderValue = stringResource(id = R.string.carSettings_vehicleType),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_licencePlate),
                    placeholderValue = stringResource(id = R.string.carSettings_licencePlate),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_amountOfPassengers),
                    placeholderValue = stringResource(id = R.string.carSettings_amountOfPassengers),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_gearboxType),
                    placeholderValue = stringResource(id = R.string.carSettings_gearboxType),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_carPriceAmount),
                    placeholderValue = stringResource(id = R.string.carSettings_carPriceAmount),
                    value = null,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.size(16.dp))

                PrimaryButtonComponent(
                    value = stringResource(id = R.string.carSettings_btn),
                    route = { }
                )
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