package com.example.fitnessapp.feature_app.domain.usecase.Workout

import com.example.fitnessapp.feature_app.domain.model.Workout
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository

class GetWorkoutUseCase(
    private val workoutRepository: WorkoutRepository
) {
    suspend operator fun invoke(): Workout{
        return workoutRepository.getWorkout()
    }
}