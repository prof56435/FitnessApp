package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import android.content.ClipDescription

data class WorkoutDetails1State(
    val name: String = "",
    val description: String = "",
    val hard: String = "",
    val error: String = "",
    val isComplete: Boolean = false
)