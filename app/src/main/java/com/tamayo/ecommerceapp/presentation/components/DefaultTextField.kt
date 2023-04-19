package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChanged: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { valueChanged ->
            onValueChanged(valueChanged)
        },
        label = { Text(text = label) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "icon"
            )
        }, keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

    )

}

@Preview
@Composable
fun MyTexFieldPreview() {
    DefaultTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChanged = {},
        label = "My TextField",
        icon = Icons.Default.Favorite
    )
}