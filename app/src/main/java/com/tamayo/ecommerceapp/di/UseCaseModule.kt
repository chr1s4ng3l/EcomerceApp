package com.tamayo.ecommerceapp.di

import android.util.Log
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.tamayo.ecommerceapp.data.service.AuthService
import com.tamayo.ecommerceapp.domain.repository.AuthRepository
import com.tamayo.ecommerceapp.domain.usecases.auth.AuthUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.GetSessionDataUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.LoginUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.LogoutUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.RegisterUseCase
import com.tamayo.ecommerceapp.domain.usecases.auth.SaveSessionUseCase
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
        login = LoginUseCase(repository),
        register = RegisterUseCase(repository),
        saveSession = SaveSessionUseCase(repository),
        getSessionData = GetSessionDataUseCase(repository),
        logout = LogoutUseCase(repository)
    )
}