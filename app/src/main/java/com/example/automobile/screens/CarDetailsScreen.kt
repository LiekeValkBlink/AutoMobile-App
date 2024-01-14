package com.example.automobile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocalGasStation
import androidx.compose.material.icons.outlined.Person
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
import com.example.automobile.components.CarInformationComponent
import com.example.automobile.components.DateTimeInputFieldComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.H3TextComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.SecondaryButtonComponent
import com.example.automobile.components.TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.Red

@Composable
fun CarDetailsScreen(navController: NavController, viewModel: CarDetailsViewModel) {
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
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.car_placeholder),
                        contentDescription = null
                    )

                    H2TextComponent(
                        value = "Kia Rio 2021"
                    )

                    TextComponent(
                        value = "Licence plate: 12-GHV-6"
                    )
                }

                Spacer(modifier = Modifier.size(32.dp))

                Column {
                    H3TextComponent(
                        value = stringResource(id = R.string.carDetails_carInformation)
                    )
                    
                    Row {

                        CarInformationComponent(
                            icon = Icons.Outlined.LocalGasStation,
                            value = "715km"

                        )

                        Spacer(modifier = Modifier.size(14.dp))


                        CarInformationComponent(
                            icon = Icons.Outlined.Person,
                            value = "4 persons"
                        )
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Row {
                        CarInformationComponent(
                            icon = Icons.Outlined.AccountTree,
                            value = "Automatic"

                        )

                        Spacer(modifier = Modifier.size(14.dp))

                        CarInformationComponent(
                            icon = Icons.Outlined.AcUnit,
                            value = "Air conditioning"
                        )
                    }
                }

                Spacer(modifier = Modifier.size(32.dp))

                Column {
                    H3TextComponent(
                        value = stringResource(id = R.string.carDetails_dateTime)
                    )
                    
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = stringResource(id = R.string.dateTimeComponent_pickUpDate_placeholder),
                                labelValue = stringResource(id = R.string.dateTimeComponent_pickUpDate_label),
                                leadingIcon = Icons.Outlined.DateRange
                            )
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = stringResource(id = R.string.dateTimeComponent_pickUpTime_placeholder),
                                labelValue = stringResource(id = R.string.dateTimeComponent_pickUpTime_label),
                                leadingIcon = Icons.Outlined.AccessTime
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = stringResource(id = R.string.dateTimeComponent_pickUpDate_placeholder),
                                labelValue = stringResource(id = R.string.dateTimeComponent_pickUpDate_label),
                                leadingIcon = Icons.Outlined.DateRange
                            )
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = stringResource(id = R.string.dateTimeComponent_pickUpTime_placeholder),
                                labelValue = stringResource(id = R.string.dateTimeComponent_pickUpTime_label),
                                leadingIcon = Icons.Outlined.AccessTime
                            )
                        }
                    }
                }
                
                PrimaryButtonComponent(
                    value = stringResource(id = R.string.carDetails_btn),
                    route = { TODO() }
                )

                Spacer(modifier = Modifier.size(16.dp))

                SecondaryButtonComponent(
                    value = stringResource(id = R.string.carDetails_secondary_btn),
                    route = { /*TODO*/ },
                    color = Red)
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
fun DefaultPreviewOfCarDetailsScreen() {
    CarDetailsScreen(navController = rememberNavController(), CarDetailsViewModel())
}