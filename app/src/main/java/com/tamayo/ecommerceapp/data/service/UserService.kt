package com.tamayo.ecommerceapp.data.service

import com.tamayo.ecommerceapp.core.Config.USER
import com.tamayo.ecommerceapp.core.Config.USER_IMAGE
import com.tamayo.ecommerceapp.domain.model.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import java.io.File

interface UserService {

    @PUT(USER)
    suspend fun update(
        @Path("id") id: String,
        @Body() user: User,
    ): Response<User>

    // Use @PUT if it's the correct HTTP method for updating user information
    @Multipart
    @PUT(USER_IMAGE)
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,   // Image file as a MultipartBody.Part
        @Path("id") id: String,           // User ID as a path parameter
        @Part("name") name: RequestBody,   // RequestBody for name field
        @Part("lastname") lastname: RequestBody,   // RequestBody for lastname field
        @Part("phone") phone: RequestBody   // RequestBody for phone field
    ): Response<User>
}
