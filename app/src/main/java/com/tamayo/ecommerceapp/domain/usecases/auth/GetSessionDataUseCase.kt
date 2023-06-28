package com.tamayo.ecommerceapp.domain.usecases.auth

import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetSessionDataUseCase @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()
}