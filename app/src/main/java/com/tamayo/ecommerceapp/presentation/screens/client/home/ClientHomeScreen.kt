package com.tamayo.ecommerceapp.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tamayo.ecommerceapp.presentation.navigation.graph.client.ClientNavGraph
import com.tamayo.ecommerceapp.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientHomeScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ClientBottomBar(navHostController = navHostController) }
    ) { _ ->

        ClientNavGraph(navHostController = navHostController)
    }

}