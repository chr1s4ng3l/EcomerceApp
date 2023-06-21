package com.tamayo.ecommerceapp.domain.model

data class AuthResponse(
    val User: User,
    val token: String
)
