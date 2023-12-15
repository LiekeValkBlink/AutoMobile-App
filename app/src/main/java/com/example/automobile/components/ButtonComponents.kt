package com.example.automobile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@Composable
fun PrimaryButtonComponent(value: String, route: () -> Unit) {
    Button(
        onClick = route,
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .height(height = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
            contentColor = White),

    ) {
        Text(
            text = value,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 6.dp)
        )
    }
}

@Composable
fun SmallPrimaryButtonComponent(value: String, route: () -> Unit) {
    Button(
        onClick = route,
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .height(height = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
            contentColor = White),

        ) {
        Text(
            text = value,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 6.dp)
        )
    }
}

@Composable
fun SecondaryButtonComponent(value: String, route: () -> Unit) {
    Button(
        onClick = route,
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .height(height = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundColor,
            contentColor = PrimaryColor),
        border = BorderStroke(2.dp, PrimaryColor)

        ) {
        Text(
            text = value,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}