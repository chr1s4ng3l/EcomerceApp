package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(vm: LoginViewModel = hiltViewModel()) {
    when (val response = vm.loginResponse) {
        is ResultState.Failure -> {

        }

        is ResultState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is ResultState.Success -> {

        }
        null -> {}
    }

}