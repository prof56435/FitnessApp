package com.example.fitnessapp.feature_app.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//Назначение: ViewModel для экрана Login
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class LoginVM: ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state
}