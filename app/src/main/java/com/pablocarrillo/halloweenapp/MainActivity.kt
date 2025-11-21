package com.pablocarrillo.halloweenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.pablocarrillo.halloweenapp.navigation.NavManager
import com.pablocarrillo.halloweenapp.ui.theme.HalloweenAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HalloweenAppTheme {
                val navController = rememberNavController()
                NavManager(navController)
            }
        }
    }
}
