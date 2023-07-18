package com.tamayo.ecommerceapp.domain.repository

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.util.ResultState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): ResultState<AuthResponse>
    suspend fun register(user: User): ResultState<AuthResponse>
    suspend fun logout()
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>

}