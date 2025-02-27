package com.example.fitnessapp.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Sleep(
    val name: String = "",
    val hours: String = "",
    val repeat: String = "",
    val user_id: String = ""
)
