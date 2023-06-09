package com.tamayo.ecommerceapp.data.repository.dataSource

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)

    fun getSessionData(): Flow<AuthResponse>
}