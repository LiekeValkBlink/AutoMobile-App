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
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TextLeadingIconInputFieldComponent
import com.example.automobile.components.DateTimeInputFieldComponent
import com.example.automobile.components.InputTextFieldWithIconComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.LightGrey


@Composable
fun HomeScreen(navController: NavController) {

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
                        leadingIcon = Icons.Filled.Search
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = "00-00-0000",
                                labelValue = "Pick-up date",
                                leadingIcon = Icons.Outlined.DateRange
                            )
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = "00:00",
                                labelValue = "Pick-up Time",
                                leadingIcon = Icons.Outlined.AccessTime
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = "00-00-0000",
                                labelValue = "Pick-up date",
                                leadingIcon = Icons.Outlined.DateRange
                            )
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            DateTimeInputFieldComponent(
                                placeholder = "00:00",
                                labelValue = "Pick-up Time",
                                leadingIcon = Icons.Outlined.AccessTime
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(20.dp))

                    PrimaryButtonComponent(
                        value = stringResource(id = R.string.home_search),
                        route = { TODO() }
                    )
                }

                Spacer(modifier = Modifier.size(40.dp))

                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        H2TextComponent(value = stringResource(id = R.string.home_available_cars))
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
                        CarComponent(
                            carBrand = "Kia Rio 2019",
                            price = 4.75,
                            image = painterResource(id = R.drawable.car_placeholder),
                            imageDescription = "description"
                        )

                        CarComponent(
                            carBrand = "Kia Rio 2019",
                            price = 4.75,
                            image = painterResource(id = R.drawable.car_placeholder),
                            imageDescription = "description"
                        )
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
    HomeScreen(navController = rememberNavController())
}