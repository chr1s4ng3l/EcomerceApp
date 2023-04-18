package com.tamayo.ecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tamayo.ecomerceapp.R
import com.tamayo.ecommerceapp.ui.theme.EcommerceAppTheme
import com.tamayo.ecommerceapp.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    LoginContent()

                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showSystemUi = true)
@Composable
fun LoginContent() {
    Box(modifier = Modifier.fillMaxSize()) {
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
                    .height(330.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Text(
                        text = "Sign In",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            modifier = Modifier.size(32.dp),
                            imageVector = Icons.Default.Email,
                            contentDescription = "Ic_Email"
                        )
                        TextField(value = "", onValueChange = {}, label = { Text(text = "Email") })

                    }

                    Spacer(modifier = Modifier.size(5.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            modifier = Modifier.size(32.dp),
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Ic_Email"
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            label = { Text(text = "Password") })

                    }



                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp), onClick = { }) {

                        Text(text = "LOGIN")

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(text = "Don't have an account? ", fontWeight = FontWeight.SemiBold)
                        Text(text = "Sign Up", fontWeight = FontWeight.Bold, color = Purple80)

                    }


                }


            }

        }


    }

}