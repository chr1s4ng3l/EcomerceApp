package com.tamayo.ecommerceapp.data.repository

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.ErrorResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.util.ConvertErrorBody
import com.tamayo.ecommerceapp.domain.util.ResponseToRequest.send
import com.tamayo.ecommerceapp.domain.util.ResultState
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): ResultState<AuthResponse> = send(
        authRemoteDataSource.login(email = email, password = password)
    )

    override suspend fun register(user: User): ResultState<AuthResponse> = send(
        authRemoteDataSource.register(user)
    )

}