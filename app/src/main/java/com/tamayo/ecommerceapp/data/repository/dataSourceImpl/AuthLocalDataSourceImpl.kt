package com.tamayo.ecommerceapp.data.repository.dataSourceImpl

import com.tamayo.ecommerceapp.data.datastore.AuthDataStore
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthLocalDataSource
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(private val authDataStore: AuthDataStore) :
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) =
        authDataStore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()

}