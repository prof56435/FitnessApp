package com.example.fitnessapp.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CompleteWorkouts(
    val name: String = "",
    val status: String = "",
    val user_id: String = ""
)
