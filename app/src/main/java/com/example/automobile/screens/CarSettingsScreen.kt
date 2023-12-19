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
import com.example.automobile.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.ImageInputFieldComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SmallTextInputFieldComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun CarSettingsScreen(navController: NavController) {
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
                    .padding(30.dp, 0.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
            ) {
                H2TextComponent(
                    value = stringResource(id = R.string.carSettings_heading)
                )
                Spacer(modifier = Modifier.size(24.dp))
                ImageInputFieldComponent(
                    image = painterResource(id = R.drawable.image_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_licencePlate_label),
                    placeholderValue = stringResource(id = R.string.carSettings_licencePlate_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_carBrand_label),
                    placeholderValue = stringResource(id = R.string.carSettings_carBrand_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_vehicleType_label),
                    placeholderValue = stringResource(id = R.string.carSettings_vehicleType_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_constructionYear_label),
                    placeholderValue = stringResource(id = R.string.carSettings_constructionYear_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_fuelType_label),
                    placeholderValue = stringResource(id = R.string.cerSettings_fuelType_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.carSettings_location_label),
                    placeholderValue = stringResource(id = R.string.carSettings_location_placeholder)
                )
                Spacer(modifier = Modifier.size(40.dp))
                PrimaryButtonComponent(
                    route = {},
                    value = stringResource(id = R.string.profileSettings_btn)
                )
                Spacer(modifier = Modifier.size(60.dp))
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
    CarSettingsScreen(navController = rememberNavController())
}