package com.tamayo.ecommerceapp.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {


    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")
        private set

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





    fun validateForm() =  viewModelScope.launch {

        if (state.name.isEmpty()){
            errorMessage = "Name required"

        }else if (state.lastName.isEmpty()){
            errorMessage = "Last Name required"

        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Invalid email"

        }else if (state.phone.isEmpty()){
            errorMessage = "Phone number required"

        }else if (state.password.length < 6){
            errorMessage = "Password must contain at least 6 characters"

        }else if (state.password != state.confirmPassword){
            errorMessage = "Passwords must be the same"
        }

        delay(3000)

        errorMessage = ""
    }
}