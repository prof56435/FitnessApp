package com.example.fitnessapp.feature_app.data.repositoryImpl

import com.example.fitnessapp.feature_app.data.network.Connect.supabase
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class AuthRepositoryImpl: AuthRepository {
    override suspend fun auth(inputEmail: String, inputPassword: String) {
        supabase.auth.signInWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }

    override suspend fun signUp(inputEmail: String, inputPassword: String) {
        supabase.auth.signUpWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }
}