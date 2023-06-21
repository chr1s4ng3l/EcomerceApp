package com.tamayo.ecommerceapp.domain.usecases.auth

import com.tamayo.ecommerceapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}