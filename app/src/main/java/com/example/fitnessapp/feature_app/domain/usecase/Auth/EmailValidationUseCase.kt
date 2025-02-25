package com.example.fitnessapp.feature_app.domain.usecase.Auth

import android.util.Patterns

class EmailValidationUseCase {
    operator fun invoke(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}