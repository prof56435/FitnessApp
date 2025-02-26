package com.example.fitnessapp.feature_app.data.repositoryImpl

import com.example.fitnessapp.feature_app.data.network.Connect.supabase
import com.example.fitnessapp.feature_app.domain.model.CompleteWorkouts
import com.example.fitnessapp.feature_app.domain.model.Workout
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getWorkout(): Workout {
        return supabase.postgrest["workout"].select(
            columns = Columns.list(
                "name",
                "description",
                "hard"
            )
        ).decodeSingle<Workout>()
    }

    override suspend fun completeWorkout(name: String, status: String) {
        val workout = CompleteWorkouts(name = name, status = status, user_id = getUserId())
        supabase.postgrest["completeWorkouts"].insert(workout)
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}