package com.example.automobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

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
    Text(text = annotatedString, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.size(30.dp))
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 40.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            lineHeight = 48.sp,
            color = White,
        )
    )
}