package com.example.automobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.R
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.SmallPrimaryButtonComponent
import com.example.automobile.components.ProfileComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.PrimaryColor

@Composable
fun ProfileScreen(navController: NavController) {
    Surface (modifier = Modifier
        .fillMaxSize()
    ){
        Column (
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
                H2TextComponent(value = stringResource(id = R.string.profile))
                ProfileComponent(
                    profileImage = painterResource(id = R.drawable.profile_placeholder),
                    username = "testpersoon",
                    email = "testpersoon@hotmail.com"
                )
                SmallPrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_complete_profile),
                    route = { navController.navigate(route = "profile_settings_screen") }
                )
                Spacer(modifier = Modifier.size(40.dp))
                H2TextComponent(value = stringResource(id = R.string.profile_your_cars))
                Spacer(modifier = Modifier.size(12.dp))
                SmallPrimaryButtonComponent(
                    value = stringResource(id = R.string.profile_add_car),
                    route = {}
                )
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
    ProfileScreen(navController = rememberNavController())
}