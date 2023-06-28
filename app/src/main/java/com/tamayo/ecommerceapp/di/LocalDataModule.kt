package com.tamayo.ecommerceapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.tamayo.ecommerceapp.core.Config.AUTH_PREF
import com.tamayo.ecommerceapp.data.datastore.AuthDataStore
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthLocalDataSource
import com.tamayo.ecommerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.tamayo.ecommerceapp.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideAuthLocalDataStore(authDataStore: AuthDataStore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore)
}