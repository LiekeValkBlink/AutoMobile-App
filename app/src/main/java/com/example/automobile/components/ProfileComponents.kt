package com.example.automobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@Composable
fun ProfileComponent(profileImage: Painter, username: String, email: String) {
    Spacer(modifier = Modifier.size(10.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = profileImage,
            contentDescription = "Profile image",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = username,
                color = White,
                fontFamily = fontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email,
                color = White,
                fontFamily = fontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}