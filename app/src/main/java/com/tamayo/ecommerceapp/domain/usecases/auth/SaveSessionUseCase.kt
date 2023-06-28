package com.tamayo.ecommerceapp.domain.usecases.auth

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import javax.inject.Inject

class SaveSessionUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)

}