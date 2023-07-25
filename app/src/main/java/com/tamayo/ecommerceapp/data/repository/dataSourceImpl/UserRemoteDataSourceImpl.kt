package com.tamayo.ecommerceapp.data.repository.dataSourceImpl

import com.tamayo.ecommerceapp.data.repository.dataSource.UserRemoteDataSource
import com.tamayo.ecommerceapp.data.service.UserService
import com.tamayo.ecommerceapp.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val userService: UserService) :
    UserRemoteDataSource {

    override suspend fun update(id: String, user: User): Response<User> =
        userService.update(id, user)

    override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"

        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

        return userService.updateWithImage(
            file = fileFormData,
            id = id,
            name = nameData,
            lastname = lastnameData,
            phone = phoneData
        )
    }
}