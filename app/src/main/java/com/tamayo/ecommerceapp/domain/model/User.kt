package com.tamayo.ecommerceapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("notification_token")
    val notificationToke: String? = null,


)
