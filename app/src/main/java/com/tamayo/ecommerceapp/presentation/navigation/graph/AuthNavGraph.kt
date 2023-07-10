package com.tamayo.ecommerceapp.presentation.navigation.graph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.register.RegisterScreen
import com.tamayo.ecommerceapp.presentation.screens.admin.home.HomeScreenAdmin
import com.tamayo.ecommerceapp.presentation.screens.client.home.HomeScreenClient
import com.tamayo.ecommerceapp.presentation.screens.roles.RolesScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navHostController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navHostController)
        }

        composable(route = AuthScreen.HomeAdmin.route) {
            HomeScreenAdmin(navHostController = navHostController)
        }

        composable(route = AuthScreen.HomeClient.route) {
            HomeScreenClient(navHostController = navHostController)
        }

        composable(route = AuthScreen.Roles.route) {
            RolesScreen(navHostController = navHostController)
        }
    }
}