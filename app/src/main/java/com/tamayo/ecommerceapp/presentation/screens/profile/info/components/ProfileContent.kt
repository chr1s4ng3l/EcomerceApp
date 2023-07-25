package com.tamayo.ecommerceapp.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tamayo.ecomerceapp.R
import com.tamayo.ecommerceapp.presentation.MainActivity
import com.tamayo.ecommerceapp.presentation.components.DefaultButton
import com.tamayo.ecommerceapp.presentation.navigation.Graph
import com.tamayo.ecommerceapp.presentation.screens.profile.info.ProfileViewModel

@Composable
fun ProfileContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: ProfileViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as? Activity

    Box(modifier = Modifier.padding(paddingValues)) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backgroundstart),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(
                        0.6f, 0.6f, 0.6f, 1f
                    )
                }
            )

        )

        Column(modifier = Modifier.fillMaxWidth()) {

            IconButton(modifier = Modifier.align(alignment = End),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }

            if (!vm.user?.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .align(alignment = CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    model = vm.user?.image,
                    contentDescription = ""
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(200.dp)
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

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors().apply { Color.White }
            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )


                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Text(text = "${vm.user?.name} ${vm.user?.lastname}")
                            Text(
                                text = "Username",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )


                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Text(text = vm.user?.email ?: "")
                            Text(
                                text = "Email",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                            Text(text = vm.user?.phone ?: "")
                            Text(
                                text = "Phone",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(48.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 80.dp),
                        textButton = "Update Profile",
                        textColor = Color.White,
                        onClick = {
                           //Log.d("TACOS", "ProfileUpdateContent: ${vm.user}")
                            navHostController.navigate("${Graph.PROFILE}/${vm.user?.toJson()}")
                        })

                }


            }

        }
    }

}
