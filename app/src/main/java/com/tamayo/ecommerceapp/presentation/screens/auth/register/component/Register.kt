package com.tamayo.ecommerceapp.presentation.screens.auth.register.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.components.ProgressBar
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {

    when (val response = vm.registerResponse) {
        is ResultState.Failure -> {
            Toast.makeText(LocalContext.current, response.exception, Toast.LENGTH_LONG).show()
        }

        is ResultState.Loading -> {
            ProgressBar()
        }

        is ResultState.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navHostController.navigate(route = AuthScreen.Home.route)
            }
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Unexpected error", Toast.LENGTH_SHORT).show()
            }

        }
    }


}