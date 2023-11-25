package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.LogoComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.dateTimeInputFieldComponent
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun HomeScreen(navController: NavController) {
    Surface (modifier = Modifier
        .background(color = BackgroundColor)
        .fillMaxSize()
        .padding(30.dp, 30.dp, 30.dp, 40.dp)
    ) {
        Column (modifier = Modifier
            .background(color = BackgroundColor)
        ) {
            Column {
                LogoComponent()
            }
            Column {
                TextInputFieldComponent (
                    labelValue = stringResource(id = R.string.home_screen_location),
                    leadingIcon = { Icons.Filled.Search }
                )
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    dateTimeInputFieldComponent(value = "Pick-up date")
                }

                Spacer(modifier = Modifier.size(20.dp))
                PrimaryButtonComponent(
                    value = stringResource(id = R.string.home_screen_search),
                    route = { TODO() }
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfHomeScreen() {
    HomeScreen(navController = rememberNavController())
}