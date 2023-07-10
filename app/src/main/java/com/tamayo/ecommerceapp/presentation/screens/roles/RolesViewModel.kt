package com.tamayo.ecommerceapp.presentation.screens.roles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
    ) : ViewModel() {

    var authResponse by mutableStateOf(AuthResponse())

    init {
        getSessionData()
    }

    private fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData.invoke().collect { data ->
            if(!data.token.isNullOrBlank()){
                authResponse = data
            }
        }
    }
}