package com.tamayo.ecommerceapp.presentation.navifation.screen

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
}
