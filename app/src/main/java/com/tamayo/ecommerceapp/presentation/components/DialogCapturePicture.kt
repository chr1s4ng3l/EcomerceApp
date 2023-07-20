package com.tamayo.ecommerceapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit

) {

    if (state.value) { // -> Show Dialog
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            onDismissRequest = { state.value = false },
            backgroundColor = MaterialTheme.colors.surface,
            title = { Text(text = "Select an option", fontSize = 20.sp) },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                ) {

                    Spacer(modifier = Modifier.width(4.dp))

                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        onClick = {
                            state.value = false
                            pickImage()
                        }) {

                        Text(text = "Gallery", color = MaterialTheme.colors.onBackground)

                    }

                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        onClick = {
                            state.value = false
                            takePhoto()
                        }) {

                        Text(text = "Camera", color = MaterialTheme.colors.onBackground)

                    }

                    Spacer(modifier = Modifier.width(4.dp))


                }
            }
        )

    }

}