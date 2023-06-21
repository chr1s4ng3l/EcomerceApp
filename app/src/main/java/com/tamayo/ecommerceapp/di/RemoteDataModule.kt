package com.tamayo.ecommerceapp.di

import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tamayo.ecommerceapp.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun providesAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)
}