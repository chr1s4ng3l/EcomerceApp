package com.tamayo.ecommerceapp.data.service

import com.tamayo.ecommerceapp.core.Config.AUTH_LOGIN
import com.tamayo.ecommerceapp.core.Config.AUTH_REGISTER
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import com.tamayo.ecommerceapp.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {


    @FormUrlEncoded
    @POST(AUTH_LOGIN)
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @POST(AUTH_REGISTER)
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>



}