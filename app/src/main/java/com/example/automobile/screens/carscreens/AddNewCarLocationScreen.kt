package com.example.automobile.screens.carscreens

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.CarComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.navigation.Navigation
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun AddNewCarLocation(postalUiState: String) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        Navigation(navController)
        val state = rememberScrollState()



        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(state = state)

                .background(BackgroundColor),
            verticalArrangement = Arrangement.Top
        ) {
            TopNavigationBar(navController)
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(30.dp, 20.dp, 30.dp, 40.dp)
            ) {
                Column {
                    H2TextComponent(value = stringResource(id = R.string.add_postal_to_car))
                    Spacer(modifier = Modifier.size(12.dp))
                    CarComponent(
                        carBrand = "Kia Rio 2019",
                        price = 4.75,
                        image = painterResource(id = R.drawable.car_placeholder),
                        imageDescription = "description"
                    )
                }

                Column {
                    Text(text = postalUiState.toString(), color = Color.White)
                    }
                Spacer(modifier = Modifier.size(12.dp))
                PrimaryButtonComponent(
                    value = stringResource(id = R.string.save_postal_btn),
                    route = { navController.navigate(route = "home_screen") },
                )
                Spacer(modifier = Modifier.size(50.dp))
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

