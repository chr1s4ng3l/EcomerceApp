package com.tamayo.ecommerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.ClientScreen
import com.tamayo.ecommerceapp.presentation.screens.client.category.list.ClientCategoryListScreen
import com.tamayo.ecommerceapp.presentation.screens.client.products.list.ClientProductListScreen
import com.tamayo.ecommerceapp.presentation.screens.profile.ProfileScreen

@Composable
fun ClientNavGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductsList.route
    ) {

        composable(route = ClientScreen.ProductsList.route) {
            ClientProductListScreen()

        }
        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen()

        }
        composable(route = ClientScreen.ProfileList.route) {
            ProfileScreen()

        }


    }

}