package com.tamayo.ecommerceapp.domain.repository

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.util.ResultState
import java.io.File

interface UserRepository {

    suspend fun update(id: String, user: User): ResultState<User>
    suspend fun updateWithImage(id: String, user: User, file: File): ResultState<User>
}