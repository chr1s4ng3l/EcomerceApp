package com.tamayo.ecommerceapp.di

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tamayo.ecommerceapp.data.service.AuthService
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.math.log

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesAuthUseCase(repository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(repository)
    )
}