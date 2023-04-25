package com.tamayo.ecommerceapp.presentation.navifation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tamayo.ecommerceapp.presentation.navifation.Graph

@Composable
fun RootNavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, route = Graph.ROOT, startDestination = Graph.AUTH){

    }

}