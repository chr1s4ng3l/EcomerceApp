package com.tamayo.ecommerceapp.data.repository

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.ErrorResponse
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.util.ConvertErrorBody
import com.tamayo.ecommerceapp.domain.util.ResultState
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): ResultState<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)

            if (result.isSuccessful) { // 201
                ResultState.Success(result.body()!!)

            } else {
                val errorResponse: ErrorResponse? =
                    ConvertErrorBody.convertErrorBody(result.errorBody())
                ResultState.Failure(errorResponse?.message ?: "Unexpected error")
            }


        } catch (e: HttpException) {
            e.printStackTrace()
            ResultState.Failure(e.message ?: "Http error request")
        } catch (e: IOException) {
            e.printStackTrace()
            ResultState.Failure("Check your network connection")
        } catch (e: Exception) {
            e.printStackTrace()
            ResultState.Failure(e.message ?: "Unexpected error")
        }
    }

}