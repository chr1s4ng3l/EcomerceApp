package com.tamayo.ecommerceapp.presentation.screens.admin.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.tamayo.ecommerceapp.presentation.screens.admin.category.list.components.AdminCategoryListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryListScreen() {

    Scaffold() { paddingValues ->

        AdminCategoryListContent(paddingValues = paddingValues)

    }

}