package com.tamayo.ecommerceapp.presentation.screens.client.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tamayo.ecommerceapp.presentation.navigation.screen.ClientScreen

@Composable
fun ClientBottomBar(navHostController: NavHostController) {
    val screens = listOf(
        ClientScreen.ProductsList,
        ClientScreen.CategoryList,
        ClientScreen.ProfileList
    )

    val navBackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar() {
            screens.forEach { screen ->

                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )


            }
        }
    }

}