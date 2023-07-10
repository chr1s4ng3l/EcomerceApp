package com.tamayo.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tamayo.ecommerceapp.domain.model.Rol

@Composable
fun RolesItem(
    rol: Rol
) {
    AsyncImage(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        model = rol.image,
        contentDescription = "ImageRol"
    )
    Text(text = rol.name, fontWeight = FontWeight.ExtraBold)

}