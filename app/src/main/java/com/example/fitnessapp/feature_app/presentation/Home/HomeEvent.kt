package com.example.fitnessapp.feature_app.presentation.Home

sealed class HomeEvent {
    data object GetName: HomeEvent()
    data object ClearError: HomeEvent()
}