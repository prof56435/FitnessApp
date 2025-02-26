package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

sealed class WorkoutDetails1Event {
    data object GetWorkout: WorkoutDetails1Event()
    data object ClearError: WorkoutDetails1Event()
    data object CompleteWorkout: WorkoutDetails1Event()
}