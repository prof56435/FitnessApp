package com.example.fitnessapp.feature_app.presentation.Profile

data class ProfileState (
    val name: String = "",
    val target: String ="",
    val height: Int = 0,
    val weight: Int = 0,
    val years: Int = 0,
    val error: String = ""
)