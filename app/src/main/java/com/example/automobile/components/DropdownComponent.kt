package com.example.automobile.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.automobile.R
import com.example.automobile.ui.theme.InputBackgroundColor
import com.example.automobile.ui.theme.White
import com.example.automobile.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInputComponent(options: Map<String, String>, defaultKey: String? = null, onChange: ((option: Map.Entry<String, String>?) -> Unit)? = null) {
    val context = LocalContext.current
    val options = options
    var selectedOption by remember { mutableStateOf(if (options[defaultKey] != null) defaultKey else null) }
    var expanded by remember { mutableStateOf(false) }

    Text(
        text = "Language",
        style = TextStyle(
            fontSize = 13.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            color = White,
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = options[selectedOption] ?: "",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .height(height = 55.dp)
                    .background(
                        color = InputBackgroundColor,
                        shape = RoundedCornerShape(size = 4.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = InputBackgroundColor,
                    focusedIndicatorColor = InputBackgroundColor,
                    cursorColor = White,
                    unfocusedIndicatorColor = InputBackgroundColor
                ),
                textStyle = TextStyle (
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = White
                ),
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.value) },
                        onClick = {
                            selectedOption = item.key
                            expanded = false
                            Toast.makeText(context, item.value, Toast.LENGTH_SHORT).show()
                            onChange?.invoke(item)
                        }
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.size(16.dp))
}
