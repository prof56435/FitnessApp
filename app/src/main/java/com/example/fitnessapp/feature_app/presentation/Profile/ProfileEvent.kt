package com.example.fitnessapp.feature_app.presentation.Profile

sealed class ProfileEvent {
    data object GetProfile: ProfileEvent()
    data object ClearError: ProfileEvent()
}