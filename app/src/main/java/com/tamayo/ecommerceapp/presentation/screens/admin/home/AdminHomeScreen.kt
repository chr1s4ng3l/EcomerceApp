package com.tamayo.ecommerceapp.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tamayo.ecommerceapp.presentation.navigation.graph.admin.AdminNavGraph
import com.tamayo.ecommerceapp.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { AdminBottomBar(navHostController = navHostController) }
    ) { _ ->
        
        AdminNavGraph(navHostController = navHostController)

    }

}