package com.tamayo.ecommerceapp.presentation.screens.client.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenClient(navHostController: NavHostController) {
    Scaffold() { paddingValues ->
        Text(modifier = Modifier.padding(paddingValues), text = "Client HomeScreen")
    }

}