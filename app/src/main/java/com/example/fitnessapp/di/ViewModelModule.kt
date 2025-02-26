package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.presentation.Home.HomeVM
import com.example.fitnessapp.feature_app.presentation.Login.LoginVM
import com.example.fitnessapp.feature_app.presentation.OnBoarding.OnBoardingVM
import com.example.fitnessapp.feature_app.presentation.Profile.ProfileVM
import com.example.fitnessapp.feature_app.presentation.RegisterPage.RegisterPageVM
import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeVM
import com.example.fitnessapp.feature_app.presentation.WorkoutDetails1.WorkoutDetails1VM
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
        LoginVM(get(), get(), get())
    }
    viewModel<RegisterPageVM>{
        RegisterPageVM(get(), get(), get())
    }
    viewModel<HomeVM>{
        HomeVM(get())
    }
    viewModel<ProfileVM>{
        ProfileVM(get())
    }
    viewModel<WorkoutDetails1VM>{
        WorkoutDetails1VM(get(), get())
    }
}