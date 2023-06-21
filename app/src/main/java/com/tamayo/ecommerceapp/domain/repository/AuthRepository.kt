package com.tamayo.ecommerceapp.domain.repository

import com.tamayo.ecommerceapp.domain.model.User

interface AuthRepository {

    suspend fun login(email: String, password: String): ResultState<User>

}