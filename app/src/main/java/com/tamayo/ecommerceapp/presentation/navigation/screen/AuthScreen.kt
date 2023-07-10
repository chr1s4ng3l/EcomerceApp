package com.tamayo.ecommerceapp.presentation.navigation.screen

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    object HomeClient: AuthScreen("homeClient")
    object HomeAdmin: AuthScreen("homeAdmin")
    object Roles: AuthScreen("roles")
}
