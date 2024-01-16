package com.example.automobile.screens.carscreens



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.data.models.CarLocation

import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun HomeScreen(
    navController: NavController,
    carsUiState: CarsUiState,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
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
                when (carsUiState) {
                    is CarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
                    is CarsUiState.Success -> HomeBody(
                        itemList = carsUiState.cars,
                        modifier = modifier
                            .padding(2.dp),
                        navController = navController
                    )

                    is CarsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
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


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading)
    )
}

/**
 * ResultScreen displaying number of photos retrieved.
 */


@Composable
fun HomeBody(
    itemList: List<CarLocation>, modifier: Modifier = Modifier, navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemList.isEmpty()) {
            Text(
                text = "",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            CarLocationList(
                carList = itemList,

                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
        PrimaryButtonComponent(
            value = "Edit Car location",
            route = { navController.navigate(route = "car_edit_screen") }
        )
    }
}

@Composable
fun CarLocationList(
    carList: List<CarLocation>, modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(items = carList) {
            CarLocationItem(
                carLocation = it,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun CarLocationItem(
    carLocation: CarLocation,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Postcode",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(Modifier.weight(1f))
                Column {
                    Text(
                        text = carLocation.postal,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

            }
            Row {
                Column {
                    Text(
                        text = "Auto ID:",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier.weight(1f))
                Column {
                    Text(
                        text = carLocation.id.toString(),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
            Row {
                Column {
                    Text(text = carLocation.latitude.toString(),
                        style = MaterialTheme.typography.titleSmall)
                }
                Spacer(modifier.weight(1f))
                Column {
                    Text(text = carLocation.longitude.toString(),
                        style = MaterialTheme.typography.titleSmall)
                }
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun CarLocationPreview() {
//
//    CarLocationItem(
//        CarLocation(1, "4761KD", 51.58471274167714, 4.797515460664405)
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HomeBodyPreview() {
//
//    HomeBody(
//        listOf(
//            CarLocation(1, "4761KD", 51.58471274167714, 4.797515460664405),
//            CarLocation(2, "4826NP", 51.68863732008763, 5.286648340047958),
//            CarLocation(3, "Avans Hogeschool Tilburg", 51.561857069415936, 5.05743959334907)
//        )
//    )
//
//}