package com.tamayo.ecommerceapp.presentation.screens.profile.update.mapper

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User{
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}