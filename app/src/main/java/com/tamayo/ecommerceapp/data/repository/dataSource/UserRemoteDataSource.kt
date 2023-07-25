package com.tamayo.ecommerceapp.data.repository.dataSource

import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import retrofit2.Response
import java.io.File

interface UserRemoteDataSource {

    suspend fun update(id: String, user: User): Response<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Response<User>
}