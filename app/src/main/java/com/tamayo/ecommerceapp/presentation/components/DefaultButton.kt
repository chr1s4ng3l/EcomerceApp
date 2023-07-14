package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamayo.ecommerceapp.presentation.ui.theme.EcommerceAppTheme
import com.tamayo.ecommerceapp.presentation.ui.theme.Purple80


@Composable
fun DefaultButton(
    modifier: Modifier,
    textButton: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = Color.Black,
    icon: ImageVector? = null

) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(color)
    ) {

        if (icon != null) {
            Icon(imageVector = icon, contentDescription = "")
        }

        Text(text = textButton, color = textColor, fontWeight = FontWeight.Bold)

    }


}

@Preview
@Composable
fun MyButtonPreview() {
    DefaultButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        textButton = "My Button",
        textColor = Color.Black,
        onClick = { })
}