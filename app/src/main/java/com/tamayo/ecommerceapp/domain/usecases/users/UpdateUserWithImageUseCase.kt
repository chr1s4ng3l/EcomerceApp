package com.tamayo.ecommerceapp.domain.usecases.users

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class UpdateUserWithImageUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)
}