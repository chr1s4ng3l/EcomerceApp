package com.tamayo.ecommerceapp.presentation.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.navigation.graph.auth.authNavGraph
import com.tamayo.ecommerceapp.presentation.navigation.graph.roles.rolesNavGraph

@Composable
fun RootNavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, route = Graph.ROOT, startDestination = Graph.AUTH) {

        authNavGraph(navHostController)
        rolesNavGraph(navHostController)


    }

}