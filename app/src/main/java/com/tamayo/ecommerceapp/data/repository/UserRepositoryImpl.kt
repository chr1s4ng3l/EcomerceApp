package com.tamayo.ecommerceapp.data.repository

import com.tamayo.ecommerceapp.data.repository.dataSource.UserRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.UserRepository
import com.tamayo.ecommerceapp.domain.util.ResponseToRequest
import com.tamayo.ecommerceapp.domain.util.ResultState
import java.io.File
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun update(id: String, user: User): ResultState<User> =
        ResponseToRequest.send(userRemoteDataSource.update(id, user))

    override suspend fun updateWithImage(id: String, user: User, file: File): ResultState<User> =
        ResponseToRequest.send(
            userRemoteDataSource.updateWithImage(id, user, file)
        )

}