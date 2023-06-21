package com.tamayo.ecommerceapp.domain.repository

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.util.ResultState

interface AuthRepository {

    suspend fun login(email: String, password: String): ResultState<AuthResponse>

}