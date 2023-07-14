package com.tamayo.ecommerceapp.presentation.navigation.graph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.RolesScreen
import com.tamayo.ecommerceapp.presentation.screens.client.home.ClientHomeScreen
import com.tamayo.ecommerceapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.rolesNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {
        composable(route = RolesScreen.Roles.route) {
            RolesScreen(navHostController)
        }

        composable(route = Graph.CLIENT) {
            ClientHomeScreen()
        }

    }
}