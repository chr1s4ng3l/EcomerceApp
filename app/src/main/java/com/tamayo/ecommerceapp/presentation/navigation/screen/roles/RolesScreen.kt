package com.tamayo.ecommerceapp.presentation.navigation.screen.roles

sealed class RolesScreen(val route: String){
    object Roles: RolesScreen(route = "roles")
}
