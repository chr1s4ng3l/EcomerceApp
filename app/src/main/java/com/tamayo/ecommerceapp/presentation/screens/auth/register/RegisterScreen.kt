package com.tamayo.ecommerceapp.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.components.DefaultTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Register",
                upAvailable = true,
                navHostController = navHostController
            )
        }
    ) { paddingValues ->
        Text(modifier = Modifier.padding(paddingValues), text = "Register screen")
    }

}