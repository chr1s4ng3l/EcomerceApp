package com.tamayo.ecommerceapp.presentation.screens.profile.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.tamayo.ecommerceapp.domain.usecases.users.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData.invoke().collect() { data ->
            user = data.user
        }

    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()

    }
}