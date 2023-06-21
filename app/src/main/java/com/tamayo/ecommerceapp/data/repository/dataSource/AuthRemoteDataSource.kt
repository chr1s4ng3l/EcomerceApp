package com.tamayo.ecommerceapp.data.repository.dataSource

import com.tamayo.ecommerceapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<User>
}