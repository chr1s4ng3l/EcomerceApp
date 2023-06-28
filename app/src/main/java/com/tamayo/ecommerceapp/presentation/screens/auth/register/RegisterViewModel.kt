package com.tamayo.ecommerceapp.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.tamayo.ecommerceapp.domain.util.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {


    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<ResultState<AuthResponse>?>(null)
        private set


    fun register() = viewModelScope.launch {
        if (isValidateForm()) {
            val user = User(
                name = state.name,
                lastname = state.lastName,
                email = state.email,
                password = state.password,
                phone = state.phone
            )
            registerResponse = ResultState.Loading
            val result = authUseCase.register(user)
            registerResponse = result //Data or Error
        }
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }


    private fun isValidateForm(): Boolean {

        if (state.name.isEmpty()) {
            errorMessage = "Name required"
            return false

        } else if (state.lastName.isEmpty()) {
            errorMessage = "Last Name required"
            return false


        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Invalid email"
            return false


        } else if (state.phone.isEmpty()) {
            errorMessage = "Phone number required"
            return false


        } else if (state.password.length < 6) {
            errorMessage = "Password must contain at least 6 characters"
            return false


        } else if (state.password != state.confirmPassword) {
            errorMessage = "Passwords must be the same"
            return false

        }
        return true
    }
}