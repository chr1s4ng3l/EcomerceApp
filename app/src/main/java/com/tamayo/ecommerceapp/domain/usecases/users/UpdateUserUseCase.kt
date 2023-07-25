package com.tamayo.ecommerceapp.domain.usecases.users

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)
}