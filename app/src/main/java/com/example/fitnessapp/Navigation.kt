package com.example.fitnessapp

sealed class NavRoutes(val route: String) {
    data object WelcomeScreen: NavRoutes("WelcomeScreen")
    data object OnBoard1: NavRoutes("OnBoard1")
}