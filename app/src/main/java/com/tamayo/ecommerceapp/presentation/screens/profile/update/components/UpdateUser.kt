package com.tamayo.ecommerceapp.presentation.screens.profile.update.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamayo.ecommerceapp.domain.util.ResultState
import com.tamayo.ecommerceapp.presentation.components.ProgressBar
import com.tamayo.ecommerceapp.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(vm: ProfileUpdateViewModel = hiltViewModel()) {

    when (val response = vm.updateResponse) {
        is ResultState.Failure -> {
            Toast.makeText(LocalContext.current, response.exception, Toast.LENGTH_SHORT)
                .show()

        }

        ResultState.Loading -> {
            ProgressBar()
        }

        is ResultState.Success -> {
            vm.updateSession(response.data)
            Log.d("TACOS", "UpdateUser: ${response.data}")
            Toast.makeText(LocalContext.current, "Profile updated successfully", Toast.LENGTH_SHORT)
                .show()

        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Underspecified error", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

}