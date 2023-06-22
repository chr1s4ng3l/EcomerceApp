package com.tamayo.ecommerceapp.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.components.Login
import com.tamayo.ecommerceapp.presentation.screens.auth.login.component.LoginContent

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navHostController: NavHostController) {

    Scaffold(){paddingValues ->
        LoginContent(paddingValues, navHostController)
    }
    
    Login(navHostController = navHostController)
    
}