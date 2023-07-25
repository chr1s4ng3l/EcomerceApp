package com.tamayo.ecommerceapp.presentation.screens.auth.register.mapper

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.presentation.screens.auth.register.RegisterState
import com.tamayo.ecommerceapp.presentation.screens.profile.update.ProfileUpdateState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastName,
        email = email,
        password = password,
        phone = phone

    )
}