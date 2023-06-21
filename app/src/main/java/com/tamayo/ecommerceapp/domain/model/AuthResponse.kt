package com.tamayo.ecommerceapp.domain.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("user")
    val user: User,
    @SerializedName("token")
    val token: String
)
