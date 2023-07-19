package com.tamayo.ecommerceapp.presentation.screens.profile.update.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tamayo.ecomerceapp.R
import com.tamayo.ecommerceapp.presentation.components.DefaultButton
import com.tamayo.ecommerceapp.presentation.components.DefaultTextField
import com.tamayo.ecommerceapp.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun ProfileUpdateContent(
    paddingValues: PaddingValues, vm: ProfileUpdateViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as? Activity
    val state = vm.state

    Box(modifier = Modifier.padding(paddingValues)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backgroundstart),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.6f, 0.6f, 0.6f, 1f
                )
            })

        )

        Column(modifier = Modifier.fillMaxWidth()) {
            
            Spacer(modifier = Modifier.height(16.dp))

            if (!vm.state.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(alignment = CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    model = state.image,
                    contentDescription = ""
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(alignment = CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(
                        id = R.drawable.user_image
                    ),
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(
                topEnd = 40.dp, topStart = 40.dp
            ), colors = CardDefaults.cardColors().apply { Color.White }) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Spacer(modifier = Modifier.height(16.dp))



                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChanged = { vm.onNameInput(it) },
                        label = "Name",
                        icon = Icons.Default.Person
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChanged = { vm.onLastNameInput(it) },
                        label = "Lastname",
                        icon = Icons.Filled.Person
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChanged = { vm.onPhoneInput(it) },
                        label = "Phone",
                        icon = Icons.Default.Phone
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                        textButton = "Done",
                        textColor = Color.White,
                        onClick = { })

                }


            }

        }
    }

}
