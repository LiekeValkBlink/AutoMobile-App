package com.example.automobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.LightGrey
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily


@Composable
fun TopNavigationBar(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = White,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
        ) {
            append("Auto")
        }
        withStyle(style = SpanStyle(
            color = PrimaryColor,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
        ) {
            append("Mobile")
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .height(80.dp)
            .padding(20.dp, 10.dp, 20.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Box {
            if (navController.previousBackStackEntry != null) {
                // Show back button if there is a previous backstack entry in the navigation stack
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Go back",
                        modifier = Modifier.offset(y = (-4).dp, x = (0).dp),
                        tint = White
                    )
                }
            }
        }

        Box {
            Text(
                text = annotatedString,
                textAlign = TextAlign.Center
            )
        }

        Box {
            IconButton(
                onClick = { navController.navigate("app_settings_screen") }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier.offset(y=(-4).dp, x=(0).dp),
                    tint = White
                )
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(BackgroundColor, shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
        .padding(20.dp, 0.dp)
        .height(60.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { navController.navigate(route = "home_screen") }
        ) {
            Icon(
                imageVector = Icons.Outlined.Home,
                modifier = Modifier.size(28.dp),
                contentDescription = "Home",
                tint = Color.LightGray
            )
        }
        IconButton(
            onClick = { navController.navigate(route = "favorites_screen") }
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                modifier = Modifier.size(26.dp),
                contentDescription = "Favorites",
                tint = Color.LightGray
            )
        }
        IconButton(
            onClick = { navController.navigate(route = "map_screen") }
        ) {
            Icon(
                imageVector = Icons.Outlined.Map,
                modifier = Modifier.size(26.dp),
                contentDescription = "Map",
                tint = LightGrey
            )
        }
        IconButton(
            onClick = { navController.navigate(route = "notifications_screen") }
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                modifier = Modifier.size(26.dp),
                contentDescription = "Notifications",
                tint = LightGrey
            )
        }
        IconButton(
            onClick = { navController.navigate(route = "profile_screen") }
        ) {
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                modifier = Modifier.size(26.dp),
                contentDescription = "Profile",
                tint = LightGrey
            )
        }
    }
}