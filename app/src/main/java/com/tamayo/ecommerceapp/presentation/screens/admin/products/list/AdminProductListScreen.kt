package com.tamayo.ecommerceapp.presentation.screens.client.products.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.tamayo.ecommerceapp.presentation.screens.admin.products.list.components.AdminProductListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminProductListScreen() {

    Scaffold() { paddingValues ->

        AdminProductListContent(paddingValues = paddingValues)

    }

}