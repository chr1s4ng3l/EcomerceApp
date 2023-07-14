package com.tamayo.ecommerceapp.presentation.screens.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.tamayo.ecommerceapp.presentation.screens.profile.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Scaffold() { paddingValues ->

        ProfileContent(paddingValues = paddingValues)

    }

}