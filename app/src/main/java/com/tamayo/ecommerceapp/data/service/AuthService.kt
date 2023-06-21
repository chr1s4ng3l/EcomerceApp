package com.tamayo.ecommerceapp.data.service

import com.tamayo.ecommerceapp.domain.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthService {


    @POST(AUTH)
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>


    companion object{
        const val BASE_URL = "http://192.168.1.85:3000/"
        const val AUTH ="auth/login"
    }

}