package com.tamayo.ecommerceapp.presentation.screens.auth.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }


    fun validateForm() = viewModelScope.launch {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Invalid email"

        }else if (state.password.length <6) errorMessage = "Password must contain at least 6 characters"


        delay(3000)
        errorMessage = ""
    }


}