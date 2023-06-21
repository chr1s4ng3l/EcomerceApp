package com.tamayo.ecommerceapp.data.repository

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.util.ResultState

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): ResultState<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            ResultState.Success(result.body()!!)

        } catch (e: Exception) {
            e.printStackTrace()
            ResultState.Failure(e)
        }
    }

}