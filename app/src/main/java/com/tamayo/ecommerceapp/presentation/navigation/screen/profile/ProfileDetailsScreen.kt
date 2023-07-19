package com.tamayo.ecommerceapp.presentation.navigation.screen.profile

sealed class ProfileDetailsScreen(val route: String){
    object ProfileUpdate: ProfileDetailsScreen(route = "profile/update")
}
