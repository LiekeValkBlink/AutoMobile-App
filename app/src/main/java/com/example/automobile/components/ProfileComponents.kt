package com.example.automobile.components

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavController
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ProfileComponent(
    profileImage: Painter,
    username: String,
    email: String,
    route: () -> Unit
) {
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
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .background(color = PrimaryColor, shape = RoundedCornerShape(100)),
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton (
                        onClick = route
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Edit profile",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}