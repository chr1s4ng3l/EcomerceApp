package com.tamayo.ecommerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.screen.AdminScreen
import com.tamayo.ecommerceapp.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.tamayo.ecommerceapp.presentation.screens.client.products.list.AdminProductListScreen
import com.tamayo.ecommerceapp.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.CLIENT,
        startDestination = AdminScreen.ProductsList.route
    ) {

        composable(route = AdminScreen.ProductsList.route) {
            AdminProductListScreen()

        }
        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen()
        }
        composable(route = AdminScreen.ProfileList.route) {
            ProfileScreen()

        }


    }

}