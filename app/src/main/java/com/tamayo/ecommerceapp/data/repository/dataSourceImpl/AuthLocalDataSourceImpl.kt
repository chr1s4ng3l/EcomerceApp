package com.tamayo.ecommerceapp.data.repository.dataSourceImpl

import com.tamayo.ecommerceapp.data.datastore.AuthDataStore
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthLocalDataSource
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(private val authDataStore: AuthDataStore) :
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) =
        authDataStore.saveUser(authResponse)

    override suspend fun updateSession(user: User) = authDataStore.updateUser(user)
    override suspend fun logout() = authDataStore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()

}