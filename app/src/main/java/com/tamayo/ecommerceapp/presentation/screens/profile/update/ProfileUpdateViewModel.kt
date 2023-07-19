package com.tamayo.ecommerceapp.presentation.screens.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val saveStateHndle: SavedStateHandle
) :
    ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())

    //Arguments
    val data = saveStateHndle.get<String>("user")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
           image = user.image?.let { user.image } ?: ""
        )

    }



    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastname: String) {
        state = state.copy(lastname = lastname)
    }

    fun onImageInput(image: String) {
        state = state.copy(image = image)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }



}