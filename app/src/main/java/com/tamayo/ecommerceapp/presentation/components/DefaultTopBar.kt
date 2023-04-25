package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null
) {

    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        navigationIcon = {
            if (upAvailable){
            IconButton(onClick = { navHostController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "ArrowBackIcon",
                    tint = Color.Black
                )

            }
            }
        }

    )

}