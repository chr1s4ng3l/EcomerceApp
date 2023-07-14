package com.tamayo.ecommerceapp.presentation.screens.auth.login.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.components.ProgressBar
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.tamayo.ecommerceapp.presentation.navigation.screen.RolesScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    val coroutine = rememberCoroutineScope()

    when (val response = vm.loginResponse) {
        is ResultState.Failure -> {
            Toast.makeText(LocalContext.current, response.exception, Toast.LENGTH_SHORT)
                .show()
        }

        ResultState.Loading -> {
            ProgressBar()
        }

        is ResultState.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1) {
                    navHostController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) {
                            inclusive = true
                        }
                    }
                } else { // Only one rol -> Client
                    navHostController.navigate(route = Graph.CLIENT) {
                        popUpTo(Graph.AUTH) {
                            inclusive = true
                        }
                    }
                }
            }


        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Underspecified error", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}