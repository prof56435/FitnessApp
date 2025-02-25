package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

//Назначение: хранение состояний экрана WelcomeScreen
//Дата: 25.02.2025
//Автор: Неробеев Алексей

data class WelcomeState (
    val next: Boolean = false,
    val goToLogin: Boolean = false,
    val onBNumber: Int = 0
)