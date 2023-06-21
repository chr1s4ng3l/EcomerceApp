package com.tamayo.ecommerceapp.data.repository.dataSourceImpl

import com.tamayo.ecommerceapp.domain.model.User
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.repository.ResultState

class AuthRepositoryImpl: AuthRepository {
    override suspend fun login(email: String, password: String): ResultState<User> {
      return ResultState.Loading
    }
}