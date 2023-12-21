package com.example.automobile.screens.mapscreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.automobile.data.models.CarLocation
import com.example.automobile.screens.carscreens.CarsUiState
import com.example.automobile.screens.carscreens.ErrorScreen
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    carsUiState: CarsUiState,
    navController: NavController,
) {

    when (carsUiState) {
        is CarsUiState.Success -> HomeMapBody(
            itemList = carsUiState.cars,
            modifier = modifier
                .padding(2.dp)
        )

        is CarsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }


}

@Composable
fun HomeMapBody(itemList: List<CarLocation>, modifier: Modifier = Modifier) {
    val carlist = itemList
    val car = carlist[0]
    Box(modifier = Modifier) {
        val carMarker = LatLng(car.latitude, car.longitude)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(carMarker, 15f)
        }
        GoogleMap(cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = MapType.TERRAIN)
        ) {

            carlist.forEach(){

                Marker(state = MarkerState(position = LatLng(it.latitude,it.longitude)))
            }
        }
    }

}
