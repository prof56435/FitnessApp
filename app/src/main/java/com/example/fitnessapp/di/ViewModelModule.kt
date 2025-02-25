package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.presentation.WelcomeScreen.WelcomeVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleVM = module {
    viewModel<WelcomeVM> {
        WelcomeVM(get(), get())
    }
}