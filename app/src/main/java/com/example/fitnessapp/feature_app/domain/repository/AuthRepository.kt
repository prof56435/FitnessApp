package com.example.fitnessapp.feature_app.domain.repository

interface AuthRepository {
    suspend fun signUp(inputEmail: String, inputPassword: String)
    suspend fun auth(inputEmail: String, inputPassword: String)
}