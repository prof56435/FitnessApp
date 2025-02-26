package com.example.fitnessapp.feature_app.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class Profile(
    val fio: String = "",
    val target: String = "",
    val number: String ="",
    val height: Int = 0,
    val weight: Int = 0,
    val years: Int = 0,
    val user_id: String = ""
)
