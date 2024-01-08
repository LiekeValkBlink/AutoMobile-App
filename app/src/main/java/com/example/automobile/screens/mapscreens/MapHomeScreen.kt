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
import com.example.automobile.data.models.haversineDistance
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
    val randomList = generateDummyData(2, 15, centerLocation)
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

                        Marker(state = MarkerState(position = LatLng(it.latitude, it.longitude)))
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