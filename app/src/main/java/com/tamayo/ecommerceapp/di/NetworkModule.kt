package com.tamayo.ecommerceapp.di

import android.util.Log
import com.google.gson.Gson
import com.tamayo.ecommerceapp.core.Config.BASE_URL
import com.tamayo.ecommerceapp.data.datastore.AuthDataStore
import com.tamayo.ecommerceapp.data.service.AuthService
import com.tamayo.ecommerceapp.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesLoginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


    @Provides
    @Singleton
    fun providesOkHttpClient(
        authDataStore: AuthDataStore, loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            authDataStore.getData().first().token
        }

        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.addInterceptor(loggingInterceptor).writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build()

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesGson(): Gson = Gson()

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)


    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

}