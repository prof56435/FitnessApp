package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

import com.example.fitnessapp.NavRoutes

//Назначение: события экрана WelcomeScreen
//Дата: 25.02.2025
//Автор: Неробеев Алексей

sealed class WelcomeEvent {
    data object GoNext: WelcomeEvent()
    data object GetPref: WelcomeEvent()
    data object SavePref: WelcomeEvent()
}