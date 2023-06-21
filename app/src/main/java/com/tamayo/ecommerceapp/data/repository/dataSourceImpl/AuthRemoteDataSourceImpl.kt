package com.tamayo.ecommerceapp.data.repository.dataSourceImpl

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl: AuthRemoteDataSource {
    override suspend fun login(): Response<User> {
        TODO("Not yet implemented")
    }

}