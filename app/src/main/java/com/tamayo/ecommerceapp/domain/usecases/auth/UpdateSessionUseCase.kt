package com.tamayo.ecommerceapp.domain.usecases.auth

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import javax.inject.Inject

class UpdateSessionUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.updateSession(user)

}