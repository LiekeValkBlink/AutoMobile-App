package com.example.automobile.screens

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.CarComponent
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.PrimaryButtonComponent
import com.example.automobile.components.ProfileComponent
import com.example.automobile.components.ProfilePictureButtonComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor


@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel) {
    val account = viewModel.account

    val context = LocalContext.current
    val imageUri by viewModel.imageUri.observeAsState()
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            viewModel.setImageUri(result.data?.data)
        }
    }
    fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryLauncher.launch(intent)
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
        ) { bitmap: Bitmap? ->
        bitmap?.let {
            val uri = viewModel.saveBitmapAndGetUri(context, it, "profile_picture.jpg")
            uri?.let { savedUri ->
               // viewModel.handleImageUri(context, savedUri)
                viewModel.setImageUri(savedUri)
                //viewModel.handleImageUri(context, save)
            }
        }
    }

    fun takePhoto() {
        cameraLauncher.launch(null)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            takePhoto()
        } else {

        }
    }

    fun requestCameraPermissionAndTakePhoto() {
        permissionLauncher.launch(android.Manifest.permission.CAMERA)
    }

    fun takePhotoWithPermissionCheck() {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            takePhoto()
        } else {
            requestCameraPermissionAndTakePhoto()
        }
    }








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
                H2TextComponent(value = stringResource(id = R.string.profile))

                ProfileComponent(
                    profileImage = imageUri?.let { rememberAsyncImagePainter(it) } ?: painterResource(id = R.drawable.profile_placeholder),
                    username = account?.email ?: "",
                    email = account?.email ?: ""
                )

                ProfilePictureButtonComponent(
                    value = ("Change Profile Picture"),
                    onClick = { pickImage()}
                )

                ProfilePictureButtonComponent(
                    value = ("Take Profile Picture"),
                    onClick = { takePhotoWithPermissionCheck()}
                )

                PrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_complete_profile),
                    route = { navController.navigate("profile_settings_screen") }
                )

                Spacer(modifier = Modifier.size(40.dp))

                H2TextComponent(value = stringResource(id = R.string.profile_your_cars))

                PrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_add_car),
                    route = { navController.navigate("car_settings_screen") }
                )

                for (car in viewModel.cars) {
                    CarComponent(
                        carId = car.id,
                        carBrand = car.carBrand + " " + car.vehicleType,
                        licencePlate = car.licencePlate,
                        carLocation = car.carLocation,
                        image = painterResource(id = R.drawable.car_placeholder),
                        amountOfPassengers = car.amountOfPassengers,
                        gearboxType = if (car.automatic) "Automatic" else "Manual",
                        price = car.carPriceAmount,
                        isOwnCar = true,
                        navController = navController,
                        viewModel = FavoritesViewModel(),
                        onClick = {
                            navController.navigate("car_settings_screen/${car.id}")
                        }
                    )
                }
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
fun DefaultPreviewOfProfileScreen() {
    ProfileScreen(navController = rememberNavController(), ProfileViewModel())
}