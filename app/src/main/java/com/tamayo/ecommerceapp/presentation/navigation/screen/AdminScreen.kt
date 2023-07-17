package com.tamayo.ecommerceapp.presentation.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList : AdminScreen(
        route = "admin/category/list",
        title = "Categories",
        icon = Icons.Default.List

    )

    object ProductsList : AdminScreen(
        route = "admin/product/list",
        title = "Products",
        icon = Icons.Default.Star

    )

    object ProfileList : AdminScreen(
        route = "admin/profile/list",
        title = "Profile",
        icon = Icons.Default.Person

    )
}
