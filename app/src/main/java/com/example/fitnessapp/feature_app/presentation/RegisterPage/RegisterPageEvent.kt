package com.example.fitnessapp.feature_app.presentation.RegisterPage

sealed class RegisterPageEvent {
    data class EnterFio(val value: String): RegisterPageEvent()
    data class EnterNumber(val value: String): RegisterPageEvent()
    data class EnterEmail(val value: String): RegisterPageEvent()
    data class EnterPassword(val value: String): RegisterPageEvent()
    data object CheckChange: RegisterPageEvent()
    data object VisualChange: RegisterPageEvent()
    data object SignUp: RegisterPageEvent()
    data object ClearError: RegisterPageEvent()
}