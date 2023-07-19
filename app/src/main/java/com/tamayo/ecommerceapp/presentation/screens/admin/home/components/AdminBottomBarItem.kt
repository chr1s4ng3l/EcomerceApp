package com.tamayo.ecommerceapp.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.tamayo.ecommerceapp.presentation.navigation.screen.admin.AdminScreen

@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any() {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(route = screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
            }
        },
        label = { Text(text = screen.title) },
        icon = { Icon(imageVector = screen.icon, contentDescription = "") }

    )


}