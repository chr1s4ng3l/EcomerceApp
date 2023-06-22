package com.tamayo.ecommerceapp.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun Login(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    val coroutine = rememberCoroutineScope()

    when (val response = vm.loginResponse) {
        is ResultState.Failure -> {
            Toast.makeText(LocalContext.current, response.exception, Toast.LENGTH_SHORT)
                .show()
        }

        ResultState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is ResultState.Success -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(route = AuthScreen.Home.route)
            }


        }
        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current, "Underspecified error", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}