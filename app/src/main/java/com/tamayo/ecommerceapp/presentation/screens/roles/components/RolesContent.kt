package com.tamayo.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamayo.ecommerceapp.presentation.screens.roles.RolesViewModel

@Composable
fun RolesContent(paddingValues: PaddingValues, rvm: RolesViewModel = hiltViewModel()) {

    val data = rvm.authResponse.user

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(items = data?.roles ?: arrayListOf()) { rol ->
            RolesItem(rol = rol)
        }


    }

}