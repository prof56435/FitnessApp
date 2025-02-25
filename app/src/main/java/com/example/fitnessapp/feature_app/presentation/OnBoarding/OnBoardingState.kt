package com.example.fitnessapp.feature_app.presentation.OnBoarding

//Назначение: хранения состояний для экранов OnBoarding
//Дата: 25.02.2025
//Автор: Неробеев Алексей

data class OnBoardingState(
    val next: Boolean = false,
    val swipe: Float = 0f
)