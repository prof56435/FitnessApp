package com.example.fitnessapp.feature_app.presentation.OnBoarding

//Назначение: события для экранов OnBoarding
//Дата: 25.02.2025
//Автор: Неробеев Алексей

sealed class OnBoardingEvent {
    data class GoNext(val value: Int): OnBoardingEvent()
    data object NotNext: OnBoardingEvent()
    data class SwipeChange(val swipe: Float, val number: Int): OnBoardingEvent()
    data object SwipeNull: OnBoardingEvent()
}