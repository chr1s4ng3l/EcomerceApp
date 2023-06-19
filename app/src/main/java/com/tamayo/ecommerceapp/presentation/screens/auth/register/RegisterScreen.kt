package com.tamayo.ecommerceapp.presentation.screens.auth.register

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.components.DefaultTopBar
import com.tamayo.ecommerceapp.presentation.screens.auth.register.component.RegisterContent

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


        RegisterContent(paddingValues)



    }

}