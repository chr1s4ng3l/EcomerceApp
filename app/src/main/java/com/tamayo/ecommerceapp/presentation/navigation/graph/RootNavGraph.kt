package com.tamayo.ecommerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tamayo.ecommerceapp.presentation.navigation.Graph

@Composable
fun RootNavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, route = Graph.ROOT, startDestination = Graph.AUTH){

        authNavGraph(navHostController)

    }

}