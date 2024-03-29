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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TextInputFieldComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.repositories.CarLocationRepository
import com.example.automobile.screens.mapscreens.AddPostalViewModel
import com.example.automobile.ui.theme.BackgroundColor
import kotlinx.coroutines.launch

@Composable
fun AddNewCarLocation(viewModel: AddPostalViewModel, navController: NavController) {
    var postcode by remember { mutableStateOf("") }
    var huisnummer by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        val state = rememberScrollState()
        var postalInput by remember { mutableStateOf("") }
        var numberInput by remember { mutableStateOf("") }
        var adresInput by remember { mutableStateOf("") }



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


                    TextInputFieldComponent(
                        value = postalInput,
                        onValueChange = {
                            postalInput = it.uppercase()
                            viewModel.getPostalData(postalInput, numberInput)
                        },
                        labelValue = stringResource(id = R.string.postal)
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    TextInputFieldComponent(
                        value = numberInput,
                        onValueChange = {
                            numberInput = it
                            viewModel.getPostalData(postalInput, numberInput)
                        },
                        labelValue = stringResource(id = R.string.number)
                    )
                    Spacer(modifier = Modifier.size(12.dp))


//                    PrimaryButtonComponent(value = "get long/lat",
//                        route = {
//                            if (numberInput.isNotBlank() && postalInput.isNotBlank()) {
//                                viewModel.getPostalData(postalInput, numberInput)
//                            }
//                        }
//                    )
                    viewModel.postalData?.let { postal ->


                        Text("Straat: ${postal.street} ${postal.house_number}", color = Color.White)
                        Text("woonplaats: ${postal.city}", color = Color.White)
                        Text("Latitude: ${postal.latitude}", color = Color.White)
                        Text("Longitude: ${postal.longitude}", color = Color.White)

                    }
                }
                Spacer(modifier = Modifier.size(12.dp))



                PrimaryButtonComponent(
                    value = stringResource(id = R.string.save_postal_btn),
                    // de route wordt de save functie

                    route = {
                        viewModel.viewModelScope.launch {
                            // create postal to save
                            val count = CarLocationRepository.getCarLocations().size
                            val postal = viewModel.postalData
                            var PostalToSave = postal?.let {
                                CarLocation(
                                    id = count,
                                    postal = it.postcode,
                                    latitude = postal.latitude,
                                    longitude = postal.longitude,
                                    number = postal.house_number.toString()
                                )
                            }


                            if (PostalToSave != null) {
//                                val count = CarsApi.retrofitService.getCarLocations().size
                                CarLocationRepository.savePostal(id = count+ 1, PostalToSave)
                            }
                        }

                        navController.navigate(route = "home_screen")
                    },
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
