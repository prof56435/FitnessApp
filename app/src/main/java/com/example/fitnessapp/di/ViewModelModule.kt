package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.presentation.Login.LoginVM
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoardingVM
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//Назначение: создание модуля для ViewModel
//Дата: 25.02.2025
//Автор: Неробеев Алексей

val moduleVM = module {
    viewModel<WelcomeVM> {
        WelcomeVM(get(), get())
    }
    viewModel<OnBoardingVM>{
        OnBoardingVM(get())
    }
    viewModel<LoginVM>{
        LoginVM()
    }
}