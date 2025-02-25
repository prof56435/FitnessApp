package com.example.fitnessapp.feature_app.presentation.Login

//Назначение: события для экрана Login
//Дата: 25.02.2025
//Автор: Неробеев Алексей

sealed class LoginEvent {
    data class EnterEmail(val email: String): LoginEvent()
    data class EnterPassword(val password: String): LoginEvent()
    data object VisualChange: LoginEvent()
    data object Auth: LoginEvent()
    data object ClearError: LoginEvent()
}