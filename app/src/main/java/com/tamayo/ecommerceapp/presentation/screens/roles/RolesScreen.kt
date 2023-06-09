package com.tamayo.ecommerceapp.presentation.screens.roles

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.components.DefaultTopBar
import com.tamayo.ecommerceapp.presentation.screens.roles.components.RolesContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RolesScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(title = "Select a role")
        }
    ) { paddingValues ->


        RolesContent(paddingValues = paddingValues, navHostController)

    }


}