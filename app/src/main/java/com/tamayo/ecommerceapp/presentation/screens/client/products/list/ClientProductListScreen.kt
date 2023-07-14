package com.tamayo.ecommerceapp.presentation.screens.client.products.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.tamayo.ecommerceapp.presentation.screens.client.products.list.components.ClientProductListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductListScreen() {

    Scaffold() { paddingValues ->

        ClientProductListContent(paddingValues = paddingValues)

    }

}