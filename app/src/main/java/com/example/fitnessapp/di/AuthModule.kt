package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.AuthRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import com.example.fitnessapp.feature_app.domain.usecase.Auth.AuthUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Auth.EmailValidationUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Auth.PasswordValidationUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Auth.SignUpUseCase
import org.koin.dsl.module

val moduleAuth = module {
    single<AuthRepository> {
        AuthRepositoryImpl()
    }
    factory<SignUpUseCase> {
        SignUpUseCase(get())
    }
    factory<AuthUseCase>{
        AuthUseCase(get())
    }
    factory<EmailValidationUseCase>{
        EmailValidationUseCase()
    }
    factory<PasswordValidationUseCase> {
        PasswordValidationUseCase()
    }
}