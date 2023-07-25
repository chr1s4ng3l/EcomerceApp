package com.tamayo.ecommerceapp.data.repository

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthLocalDataSource
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.ErrorResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.util.ConvertErrorBody
import com.tamayo.ecommerceapp.domain.util.ResponseToRequest.send
import com.tamayo.ecommerceapp.domain.util.ResultState
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): ResultState<AuthResponse> = send(
        authRemoteDataSource.login(email = email, password = password)
    )

    override suspend fun register(user: User): ResultState<AuthResponse> = send(
        authRemoteDataSource.register(user)
    )

    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override suspend fun saveSession(authResponse: AuthResponse) =
        authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}