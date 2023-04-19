package com.tamayo.ecommerceapp.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tamayo.ecommerceapp.presentation.screens.auth.login.component.LoginContent

@Preview
@ExperimentalMaterial3Api
@Composable
fun LoginScreen() {

    Scaffold(){paddingValues ->
        LoginContent(paddingValues)
    }
    
}