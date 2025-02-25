package com.example.fitnessapp.feature_app.domain.usecase.Auth

import com.example.fitnessapp.feature_app.domain.repository.AuthRepository

class AuthUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String){
        authRepository.auth(email, password)
    }
}