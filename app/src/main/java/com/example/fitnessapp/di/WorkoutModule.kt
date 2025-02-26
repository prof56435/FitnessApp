package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.WorkoutRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import com.example.fitnessapp.feature_app.domain.usecase.Workout.CompleteWorkoutUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Workout.GetWorkoutUseCase
import org.koin.dsl.module

val moduleWorkout = module {
    single<WorkoutRepository>{
        WorkoutRepositoryImpl()
    }
    factory<GetWorkoutUseCase> {
        GetWorkoutUseCase(get())
    }
    factory<CompleteWorkoutUseCase> {
        CompleteWorkoutUseCase(get())
    }
}