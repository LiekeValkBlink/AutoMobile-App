package com.example.automobile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily


@Composable
fun topNav(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Box {
            IconButton(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Go back",
                    modifier = Modifier.offset(y=(-4).dp, x=(-12).dp),
                    tint = White
                )
        }

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LogoComponent()
        }
        }
    }

    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun LogoComponent() {
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
    Text(
        text = annotatedString,
        textAlign = TextAlign.Center
    )
}