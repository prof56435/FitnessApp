package com.example.fitnessapp.feature_app.presentation.RegisterPage

data class RegisterPageState (
    val fio: String = "",
    val number: String = "",
    val email: String = "",
    val password: String = "",
    val check: Boolean = false,
    val visual: Boolean = true,
    val error: String = "",
    val isComplete: Boolean = false
)