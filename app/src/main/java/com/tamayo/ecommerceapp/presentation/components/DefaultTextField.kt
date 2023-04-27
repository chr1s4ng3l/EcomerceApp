package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChanged: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    hideText: Boolean = false
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
        },
        keyboardOptions = keyboardOptions,

        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None


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