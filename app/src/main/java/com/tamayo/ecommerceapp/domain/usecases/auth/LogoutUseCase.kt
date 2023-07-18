package com.tamayo.ecommerceapp.domain.usecases.auth

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke() = repository.logout()

}