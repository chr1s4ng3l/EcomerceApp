package com.tamayo.ecommerceapp.core

object Config {

    //SERVICE API
    const val BASE_URL = "http://10.0.0.137:3000/"
//    const val BASE_URL = "http://192.168.1.85:3000/"
    const val AUTH_LOGIN = "auth/login"
    const val AUTH_REGISTER = "auth/register"
    const val USER = "users/{id}"
    const val USER_IMAGE = "users/upload/{id}"

    //DATA STORE
    const val AUTH_PREF = "AUTH_PREF"
    const val AUTH_KEY = "AUTH_KEY"


}