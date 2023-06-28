package com.tamayo.ecommerceapp.domain.usecases.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase
)
