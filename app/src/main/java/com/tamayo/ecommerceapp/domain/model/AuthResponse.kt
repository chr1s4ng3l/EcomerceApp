package com.tamayo.ecommerceapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("user")
    val user: User,
    @SerializedName("token")
    val token: String
) {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }
}
