package com.tamayo.ecommerceapp.presentation.screens.auth.login.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavHostController
import com.tamayo.ecomerceapp.R
import com.tamayo.ecommerceapp.presentation.components.DefaultButton
import com.tamayo.ecommerceapp.presentation.components.DefaultTextField
import com.tamayo.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.tamayo.ecommerceapp.presentation.screens.auth.login.LoginViewModel
import com.tamayo.ecommerceapp.presentation.ui.theme.Blue80

@ExperimentalMaterial3Api
@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: LoginViewModel = hiltViewModel()
) {


    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if (vm.errorMessage != "") Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f)
            })
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "blue cart"
            )

            Text(
                text = "Ecommerce App",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
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
                        text = "Sign In",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )


                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.email,
                        onValueChanged = { vm.onEmailInput(it)},
                        label = "Email",
                        icon = Icons.Default.Email,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.size(5.dp))

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.state.password,
                        onValueChanged = { vm.onPasswordInput(it)},
                        label = "Password",
                        icon = Icons.Default.Lock,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        hideText = true
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        textButton = "Log In",
                        color = Blue80,
                        textColor = Color.White,
                        onClick = { vm.login() })

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "Don't have an account? ",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray
                        )
                        Text(modifier = Modifier.clickable {
                            navHostController.navigate(AuthScreen.Register.route)
                        }, text = "Sign Up", fontWeight = FontWeight.Bold, color = Color.Black)

                    }


                }


            }

        }


    }

}