package com.tamayo.ecommerceapp.presentation.navigation.graph.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.auth.AuthScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.register.RegisterScreen

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

    }
}