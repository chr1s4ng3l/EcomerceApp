package com.tamayo.ecommerceapp.di

import com.tamayo.ecommerceapp.data.repository.AuthRepositoryImpl
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthLocalDataSource
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tamayo.ecommerceapp.data.service.AuthService
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)
}