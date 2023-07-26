package com.tamayo.ecommerceapp.presentation.screens.profile.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.tamayo.ecommerceapp.domain.usecases.users.UsersUseCase
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.screens.profile.update.mapper.toUser
import com.tamayo.ecommerceapp.presentation.util.ComposeFileProvider
import com.tamayo.ecommerceapp.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val saveStateHandle: SavedStateHandle,
    private val userUseCase: UsersUseCase,
    @ApplicationContext private val context: Context
) :
    ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())

    //Arguments
    val data = saveStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    //Images
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler() // Work with images in the view model

    var updateResponse by mutableStateOf<ResultState<User>?>(null)
        private set

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image
        )

    }

    fun onUpdate() {
        if (file != null) {
            updateWithImage()
        }
        else {
            updateProfile()
        }
    }

    private fun updateWithImage() = viewModelScope.launch {
        updateResponse = ResultState.Loading
        val result = userUseCase.updateUserWithImageUseCase(user.id ?: " ", state.toUser(), file!!)
        updateResponse = result
    }

    fun updateSession(userResponse: User) = viewModelScope.launch {
        authUseCase.updateSessionUseCase.invoke(userResponse)
    }

    private fun updateProfile() = viewModelScope.launch {

        updateResponse = ResultState.Loading
        val result = userUseCase.updateUserUseCase(user.id ?: " ", state.toUser())
        updateResponse = result
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent(type = "image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = state.image?.let {
                File(it)
            }
        }
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