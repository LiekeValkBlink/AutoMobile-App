package com.example.automobile.screens

import android.renderscript.ScriptGroup.Input
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.TestModifierUpdaterLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.components.BottomNavigationBar
import com.example.automobile.components.H2TextComponent
import com.example.automobile.components.TopNavigationBar
import com.example.automobile.ui.theme.BackgroundColor
import androidx.compose.ui.unit.dp
import com.example.automobile.components.DateTimeInputFieldComponent
import com.example.automobile.components.InputTextFieldWithIconComponent
import com.example.automobile.ui.theme.InputBackgroundColor
import com.example.automobile.ui.theme.White

@Composable
fun FavoritesScreen(navController: NavController) {
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
                    .fillMaxWidth()
                    .padding(30.dp, 0.dp),
                ) {
                H2TextComponent(value = "Favorites Screen")
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
fun DefaultPreviewOfFavoritesScreen() {
    FavoritesScreen(navController = rememberNavController())
}