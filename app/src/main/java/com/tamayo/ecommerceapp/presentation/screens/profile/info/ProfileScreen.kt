package com.tamayo.ecommerceapp.presentation.screens.profile.info

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.screens.profile.info.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navHostController: NavHostController) {

    Scaffold() { paddingValues ->

        ProfileContent(paddingValues = paddingValues, navHostController)

    }

}