package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.feature_app.presentation.Home.HomeScreen
import com.example.fitnessapp.feature_app.presentation.Login.LoginScreen
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoarding1Screen
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoarding2Screen
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoarding3Screen
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoarding4Screen
import com.example.fitnessapp.feature_app.presentation.Profile.ProfileScreen
import com.example.fitnessapp.feature_app.presentation.RegisterPage.RegisterPageScreen
import com.example.fitnessapp.feature_app.presentation.SuccessRegistration.SuccessRegistrationScreen
import com.example.fitnessapp.feature_app.presentation.Target.TargetScreen
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeScreen
import com.example.fitnessapp.feature_app.presentation.ui.theme.FitnessAppTheme

//Назначение: настройка NavHost
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = NavRoutes.WelcomeScreen.route){
                    composable(NavRoutes.WelcomeScreen.route) { WelcomeScreen(navController)  }
                    composable(NavRoutes.OnBoard1.route) { OnBoarding1Screen(navController)  }
                    composable(NavRoutes.OnBoard2.route) { OnBoarding2Screen(navController)  }
                    composable(NavRoutes.OnBoard3.route) { OnBoarding3Screen(navController)  }
                    composable(NavRoutes.OnBoard4.route) { OnBoarding4Screen(navController)  }
                    composable(NavRoutes.Login.route) { LoginScreen(navController)  }
                    composable(NavRoutes.RegisterPage.route) { RegisterPageScreen(navController)  }
                    composable(NavRoutes.Home.route) { HomeScreen(navController)  }
                    composable(NavRoutes.Target.route) { TargetScreen(navController)  }
                    composable(NavRoutes.Successful.route){ SuccessRegistrationScreen(navController)}
                    composable(NavRoutes.Profile.route) { ProfileScreen(navController)  }
                }
            }
        }
    }
}
