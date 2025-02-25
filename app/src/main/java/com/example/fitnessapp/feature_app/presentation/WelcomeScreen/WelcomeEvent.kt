package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

import com.example.fitnessapp.NavRoutes

sealed class WelcomeEvent {
    data object GoNext: WelcomeEvent()
    data object GetPref: WelcomeEvent()
    data object SavePref: WelcomeEvent()
}