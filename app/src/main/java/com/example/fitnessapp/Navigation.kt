package com.example.fitnessapp

//Назначение: создание объектов для навигации
//Дата: 25.02.2025
//Автор: Неробеев Алексей

sealed class NavRoutes(val route: String) {
    data object WelcomeScreen: NavRoutes("WelcomeScreen")
    data object OnBoard1: NavRoutes("OnBoard1")
    data object OnBoard2: NavRoutes("OnBoard2")
    data object OnBoard3: NavRoutes("OnBoard3")
    data object OnBoard4: NavRoutes("OnBoard4")
    data object Login: NavRoutes("Login")
}