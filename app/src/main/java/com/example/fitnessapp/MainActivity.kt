package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoarding1Screen
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeScreen
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = NavRoutes.WelcomeScreen.route){
                    composable(NavRoutes.WelcomeScreen.route) { WelcomeScreen(navController)  }
                    composable(NavRoutes.OnBoard1.route) { OnBoarding1Screen(navController)  }
                }
            }
        }
    }
}
