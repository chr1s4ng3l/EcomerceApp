package com.tamayo.ecommerceapp.presentation.screens.roles.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tamayo.ecommerceapp.presentation.screens.roles.RolesViewModel

@Composable
fun RolesContent(paddingValues: PaddingValues, rvm: RolesViewModel = hiltViewModel()) {

    val data = rvm.authResponse.user

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        items(items = data?.roles!!) { rol ->
            AsyncImage(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                model = rol.image,
                contentDescription = "ImageRol"
            )

            Text(text = rol.name)
        }


    }

}