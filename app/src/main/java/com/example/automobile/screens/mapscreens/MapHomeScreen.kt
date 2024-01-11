package com.example.automobile.screens.mapscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.automobile.app.generateDummyData
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.data.models.CarLocation
import com.example.automobile.screens.carscreens.CarsUiState
import com.example.automobile.screens.carscreens.ErrorScreen
import com.example.automobile.ui.theme.BackgroundColor
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.serialization.Serializable
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    carsUiState: CarsUiState,
    navController: NavController,
) {

    when (carsUiState) {
        is CarsUiState.Success -> HomeMapBody(
            navController = navController,
            itemList = carsUiState.cars,
            modifier = modifier
                .padding(2.dp)
        )

        is CarsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Serializable
data class Location(val latitude: Double, val longitude: Double)

@Composable
fun HomeMapBody(
    itemList: List<CarLocation>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val carlist = itemList
    val currentLocation = Location(51.6466733, 4.6023077)
    val centerLocation = com.example.automobile.app.Location(51.6466733, 4.6023077)
    val randomList = generateDummyData(6, 15, centerLocation)
    val locationList = filterLocationsByDistance(currentLocation, randomList, 5.0)


    val car = carlist[0]

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(BackgroundColor),
            verticalArrangement = Arrangement.Top
        ) {
            TopNavigationBar(navController = navController)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(30.dp, 0.dp)
            ) {
                val carMarker = LatLng(car.latitude, car.longitude)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(carMarker, 15f)
                }
                GoogleMap(
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(mapType = MapType.TERRAIN)
                ) {

                    locationList.forEach() {
                        val rangeKM = haversineDistance(centerLocation.latitude, centerLocation.longitude,it.latitude,it.longitude)
                        Marker(state = MarkerState(position = LatLng(it.latitude, it.longitude)),
                            title = "%.2f km".format(rangeKM))
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

@Composable
fun filterLocationsByDistance(
    currentLocation: com.example.automobile.screens.mapscreens.Location,
    locations: List<CarLocation>,
    maxDistance: Double
): MutableList<CarLocation> {
    val nearbyLocations = mutableListOf<CarLocation>()

    for (location in locations) {
        val distance = haversineDistance(
            currentLocation.latitude, currentLocation.longitude,
            location.latitude, location.longitude
        )

        if (distance <= maxDistance) {
            nearbyLocations.add(location)
        }
    }

    return nearbyLocations
}


//functie om de afstand tussen twee locaties te berekenen.
fun haversineDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val R = 6371.0  // Aardstraal in kilometers

    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)

    val a = sin(dLat / 2).pow(2) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return R * c
}