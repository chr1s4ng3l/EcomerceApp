package com.tamayo.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tamayo.ecommerceapp.domain.model.Rol
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RolesItem(
    rol: Rol,
    navHostController: NavHostController
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.outlinedCardColors(),
        onClick = {
//            navHostController.navigate(route = rol.route) {
//                popUpTo(route = AuthScreen.Roles.route) {
//                    inclusive = true
//                }
//            }
        }) {
        AsyncImage(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            model = rol.image,
            contentDescription = "ImageRol"
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = rol.name,
            fontWeight = FontWeight.ExtraBold
        )

    }
}