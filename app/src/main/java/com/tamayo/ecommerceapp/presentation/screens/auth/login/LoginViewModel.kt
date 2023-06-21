package com.tamayo.ecommerceapp.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        private set

    // LOGIN RESPONSE
    var loginResponse by mutableStateOf<ResultState<User>?>(null)
        private set

    fun login() = viewModelScope.launch {
        if (isValidateForm()) {
            loginResponse = ResultState.Loading // Waiting for data
            val result = authUseCase.login(state.email, state.password) //Return the request
            loginResponse = result // Success
            Log.d("LoginViewModel", "Response => $loginResponse")
        }

    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }


    fun isValidateForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Invalid email"
            return false

        } else if (state.password.length < 6) {
            errorMessage = "Password must contain at least 6 characters"
            return false
        }
        return true
    }


}