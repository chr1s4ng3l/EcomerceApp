package com.tamayo.ecommerceapp.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.profile.ProfileDetailsScreen
import com.tamayo.ecommerceapp.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.profileNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileDetailsScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileDetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            }
            )
        ) {
            it.arguments?.getString("user")?.let { userArg ->
                ProfileUpdateScreen(navHostController, userArg)
            }
        }


    }
}