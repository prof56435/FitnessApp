package com.example.fitnessapp.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Workout(
    val name: String = "",
    val description: String = "",
    val hard: String = ""
)
