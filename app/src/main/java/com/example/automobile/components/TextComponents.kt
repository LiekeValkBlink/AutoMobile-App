package com.example.automobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.automobile.ui.theme.BackgroundColor
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@Composable
fun AnnotatedString(startValue: String, endValue: String, fontSize: Int, route: (Int) -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = White,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = fontSize.sp
        )
        ) {
            append(startValue)
        }
        withStyle(style = SpanStyle(
            color = PrimaryColor,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp
        )
        ) {
            append(" $endValue")
        }
    }

    ClickableText(
        modifier = Modifier.fillMaxWidth(),
        text = annotatedString,
        onClick = route,
        style = TextStyle(textAlign = TextAlign.Center)
    )
}

@Composable
fun TextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp,
            color = White,
        )
    )
}

@Composable
fun H1TextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 38.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            lineHeight = 44.sp,
            color = White,
        )
    )
}

@Composable
fun H2TextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .background(color = BackgroundColor),
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = White,
        )
    )
}