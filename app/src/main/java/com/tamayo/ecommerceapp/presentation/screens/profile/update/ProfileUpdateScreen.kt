package com.tamayo.ecommerceapp.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.presentation.components.DefaultTopBar
import com.tamayo.ecommerceapp.presentation.screens.profile.update.components.ProfileUpdateContent
import com.tamayo.ecommerceapp.presentation.screens.profile.update.components.UpdateUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navHostController: NavHostController, userArg: String) {
    Log.d("Lola", "ProfileUpdateScreen: $userArg")
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Updating profile", true, navHostController = navHostController)
        }
    ) { paddingValues ->

        ProfileUpdateContent(paddingValues = paddingValues)

    }

    UpdateUser()

}