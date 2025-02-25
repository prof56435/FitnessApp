package com.example.fitnessapp.feature_app.domain.usecase.Auth

class PasswordValidationUseCase {
    operator fun invoke(password: String): Boolean{
        return password.length >= 6
    }
}