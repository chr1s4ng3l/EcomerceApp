package com.tamayo.ecommerceapp.presentation.screens.client.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.tamayo.ecommerceapp.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.tamayo.ecommerceapp.presentation.screens.profile.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientCategoryListScreen() {

    Scaffold() { paddingValues ->

        ClientCategoryListContent(paddingValues = paddingValues)

    }

}