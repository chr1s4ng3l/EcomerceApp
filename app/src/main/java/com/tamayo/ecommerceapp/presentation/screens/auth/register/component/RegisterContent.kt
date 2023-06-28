package com.tamayo.ecommerceapp.presentation.screens.auth.register.component

import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamayo.ecomerceapp.R
import com.tamayo.ecommerceapp.presentation.components.DefaultButton
import com.tamayo.ecommerceapp.presentation.components.DefaultTextField
import com.tamayo.ecommerceapp.presentation.screens.auth.register.RegisterViewModel
import com.tamayo.ecommerceapp.presentation.ui.theme.Blue80

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm: RegisterViewModel = hiltViewModel()) {

    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
            vm.errorMessage = ""
        }
    }

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner_form),
            contentDescription = "User Image",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f)
            })
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.user_form),
                contentDescription = ""
            )

            Text(
                text = "Fill the form",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                colors = CardDefaults.cardColors(Color.White.copy(0.9f))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp)
                        .verticalScroll(rememberScrollState())

                ) {

                    Text(
                        modifier = Modifier.padding(bottom = 16.dp),
                        text = "Sign Up",
                        fontSize = 28.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.name,
                        onValueChanged = { vm.onNameInput(it) },
                        label = "Name",
                        icon = Icons.Default.Person,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.lastName,
                        onValueChanged = { vm.onLastNameInput(it) },
                        label = "Last Name",
                        icon = Icons.Outlined.Person,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.email,
                        onValueChanged = { vm.onEmailInput(it) },
                        label = "Email",
                        icon = Icons.Default.Email,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.phone,
                        onValueChanged = { vm.onPhoneInput(it) },
                        label = "Phone",
                        icon = Icons.Default.Phone,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.password,
                        onValueChanged = { vm.onPasswordInput(it) },
                        label = "Password",
                        icon = Icons.Default.Lock,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        hideText = true

                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.confirmPassword,
                        onValueChanged = { vm.onConfirmPasswordInput(it) },
                        label = "Confirm Password",
                        icon = Icons.Outlined.Lock,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        hideText = true

                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        textButton = "Confirm",
                        color = Blue80,
                        textColor = Color.White,
                        onClick = { vm.register() })

                }


            }


        }


    }

}