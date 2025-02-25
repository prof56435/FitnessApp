package com.example.fitnessapp.feature_app.presentation.Login

import androidx.compose.ui.text.input.PasswordVisualTransformation

//Назначение: хранение состояний экрана Login
//Дата: 25.02.2025
//Автор: Неробеев Алексей

data class LoginState (
    val isComplete: Boolean = false,
    val email: String = "",
    val password: String = "",
    val visual: Boolean = true,
    val error: String = ""
)