package com.tamayo.ecommerceapp.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList : ClientScreen(
        route = "client/category/list",
        title = "Categories",
        icon = Icons.Default.List

    )

    object ProductsList : ClientScreen(
        route = "client/product/list",
        title = "Products",
        icon = Icons.Default.Star

    )

    object ProfileList : ClientScreen(
        route = "client/profile/list",
        title = "Profile",
        icon = Icons.Default.Person

    )

}
