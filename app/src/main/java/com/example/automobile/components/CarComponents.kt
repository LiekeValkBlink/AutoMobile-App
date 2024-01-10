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
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.automobile.ui.theme.InputBackgroundColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.automobile.ui.theme.LightGrey
import com.example.automobile.ui.theme.MediumGrey
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily
import com.example.automobile.R
import kotlin.math.round

@Composable
fun CarComponent(
    carBrand: String,
    licencePlate: String,
    image: Painter,
    amountOfPassengers: Int,
    gearboxType: String,
    price: Double,
    isOwnCar: Boolean = false,
    carId: Int? = null,
    navController: NavController? = null
    ) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = 18.sp,
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
        .padding(20.dp, 20.dp, 20.dp, 14.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Column {
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = carBrand,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        color = White,
                    )
                )

                Text(
                    text = licencePlate,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Medium,
                        color = LightGrey,
                    )
                )
            }

            if (isOwnCar) {
                IconButton(
                    onClick = {
                        if (navController != null && carId != null) {
                            navController.navigate("car_settings_screen/${carId}")
                        }
                    },
                    modifier = Modifier
                        .background(
                            MediumGrey,
                            RoundedCornerShape(100.dp)
                        )
                        .height(40.dp)
                        .width(40.dp)

                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit",
                        tint = LightGrey
                    )
                }
            } else {
                IconButton(
                    onClick = { },
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
                        contentDescription = "Favorite",
                        tint = LightGrey
                    )
                }
            }
        }

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .background(InputBackgroundColor)
        )

        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (modifier = Modifier
                .padding(top = 2.dp)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Amount of passengers",
                        tint = PrimaryColor
                    )

                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = amountOfPassengers.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Medium,
                            color = White,
                        )
                    )
                }

                Spacer(modifier = Modifier.size(12.dp))

                Row {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        imageVector = Icons.Filled.AccountTree,
                        contentDescription = "Gearbox type",
                        tint = PrimaryColor
                    )
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = gearboxType,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Medium,
                            color = White,
                        )
                    )
                }
            }

            Text(
                text = annotatedString
            )
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun CarInformationComponent (
    icon: ImageVector,
    value: String
) {
    Row (
        modifier = Modifier
            .background(color = InputBackgroundColor, shape = RoundedCornerShape(50.dp))
            .padding(20.dp, 12.dp, 20.dp, 10.dp),
    ){
        Icon(
            modifier = Modifier
                .size(20.dp)
                .padding(top = 1.dp, end = 4.dp),
            imageVector = icon,
            contentDescription = null,
            tint = White
        )
        Text(
            text = value,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                color = White,
            )
        )
    }
}