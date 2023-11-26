package com.example.automobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.R
import com.example.automobile.ui.theme.InputBackgroundColor
import com.example.automobile.ui.theme.LightGrey
import com.example.automobile.ui.theme.PrimaryColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputFieldComponent(
    labelValue: String, ) {

    val textValue = remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        placeholder = {
            Text(text = labelValue, color = LightGrey)
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(height = 55.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = InputBackgroundColor,
            focusedIndicatorColor = PrimaryColor,
            textColor = White,
            cursorColor = White,
            unfocusedIndicatorColor = InputBackgroundColor,
        ),
        textStyle = TextStyle (
          fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),

        keyboardOptions = KeyboardOptions.Default,
        maxLines = 1,
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextLeadingIconInputFieldComponent(
    labelValue: String,
    leadingIcon: ImageVector,
) {
    val textValue = remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        placeholder = {
            Text(text = labelValue, color = LightGrey)
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = InputBackgroundColor,
            focusedIndicatorColor = PrimaryColor,
            textColor = White,
            cursorColor = White,
            unfocusedIndicatorColor = InputBackgroundColor,
        ),
        textStyle = TextStyle (
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),

        keyboardOptions = KeyboardOptions.Default,
        maxLines = 1,

        leadingIcon = {
            Icon (
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                tint = White
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputFieldComponent(labelValue: String) {

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    TextField(
        value = password.value,
        onValueChange = {
            password.value = it
        },
        placeholder = {
            Text(text = labelValue, color = LightGrey)
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(height = 55.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = InputBackgroundColor,
            focusedIndicatorColor = PrimaryColor,
            textColor = White,
            cursorColor = White,
            unfocusedIndicatorColor = InputBackgroundColor
        ),
        textStyle = TextStyle (
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        maxLines = 1,
        trailingIcon = {

            val iconImage = if(passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if(passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(
                onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description,
                    modifier = Modifier.size(20.dp),
                    tint = White,)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
            PasswordVisualTransformation()
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimeInputFieldComponent (
    value: String,
    labelValue: String,
    leadingIcon: ImageVector ) {

    val dateTime = remember {
        mutableStateOf("")
    }

    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(InputBackgroundColor,
                    shape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
                )
                .padding(8.dp, 8.dp, 0.dp, 8.dp)
        ){
            Icon(
                imageVector = leadingIcon,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 6.dp),
                contentDescription = null,
                tint = White
            )
            Text(
                text = labelValue,
                color = White,

            )
        }

        TextField(
            value = dateTime.value,
            onValueChange = {
                dateTime.value = it
            },
            placeholder = { Text(text = value) },
            modifier = Modifier
                .height(height = 40.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = InputBackgroundColor,
                focusedIndicatorColor = PrimaryColor,
                textColor = White,
                cursorColor = White,
                unfocusedIndicatorColor = InputBackgroundColor,
                placeholderColor = LightGrey
            ),
            textStyle = TextStyle (
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 0.sp,
            ),
            shape = RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1,
        )
    }
}

