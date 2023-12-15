package com.example.automobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.automobile.ui.theme.InputBackgroundColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.ui.theme.LightGrey
import com.example.automobile.ui.theme.MediumGrey
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@Composable
fun CarComponent(
    carBrand: String,
    price: Double,
    image: Painter,
    imageDescription: String) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = White,
        )) {
            append("€ $price")
        }
        withStyle(style = SpanStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            color = LightGrey,
        )) {
            append("/hour")
        }
    }

    Column (modifier = Modifier
        .background(
            InputBackgroundColor,
            shape = RoundedCornerShape(4.dp)
        )
        .fillMaxWidth()
        .padding(20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = annotatedString
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(
                        MediumGrey,
                        RoundedCornerShape(100.dp)
                    )
                    .height(40.dp)
                    .width(40.dp)
                    .padding(top = 2.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Filter",
                    tint = LightGrey
                )
            }
        }

        Image(
            painter = image,
            contentDescription = imageDescription,
            modifier = Modifier
                .fillMaxWidth()
                .background(InputBackgroundColor)
        )

        Text(
           text = carBrand,
           style = TextStyle(
               fontSize = 16.sp,
               fontFamily = fontFamily,
               fontWeight = FontWeight.Bold,
               color = White,
           )
        )
    }
    Spacer(modifier = Modifier.size(20.dp))
}