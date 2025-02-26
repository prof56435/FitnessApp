package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.model.Workout

interface WorkoutRepository {
    suspend fun getWorkout(): Workout
    suspend fun completeWorkout(name: String, status: String)
}