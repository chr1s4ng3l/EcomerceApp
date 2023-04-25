package com.tamayo.ecommerceapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tamayo.ecommerceapp.presentation.navifation.graph.RootNavGraph
import com.tamayo.ecommerceapp.presentation.ui.theme.EcommerceAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    navHostController = rememberNavController()

                    RootNavGraph(navHostController = navHostController)
                }
            }
        }
    }
}


