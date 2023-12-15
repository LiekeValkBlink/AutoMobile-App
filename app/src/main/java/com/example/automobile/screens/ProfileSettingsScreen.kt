package com.example.automobile.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.automobile.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.SmallPrimaryButtonComponent
import com.example.automobile.components.SmallTextInputFieldComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor

@Composable
fun ProfileSettingsScreen(navController: NavController) {
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
                    .padding(30.dp, 0.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                H2TextComponent(
                    value = stringResource(id = R.string.profileSettings_heading)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_username_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_username_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_fullName_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_fullName_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_email_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_email_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_telephoneNumber_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_telephoneNumber_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_dateOfBirth_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_dateOfBirth_placeholder)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SmallTextInputFieldComponent(
                    labelValue = stringResource(id = R.string.profileSettings_DriversLicenceNumber_label),
                    placeholderValue = stringResource(id = R.string.profileSettings_DriversLicenceNumber_placeholder)
                )
                Spacer(modifier = Modifier.size(30.dp))
                SmallPrimaryButtonComponent(
                    route = {},
                    value = stringResource(id = R.string.profileSettings_btn)
                )
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
fun DefaultPreviewOfProfileSettingsScreen() {
    ProfileSettingsScreen(navController = rememberNavController())
}