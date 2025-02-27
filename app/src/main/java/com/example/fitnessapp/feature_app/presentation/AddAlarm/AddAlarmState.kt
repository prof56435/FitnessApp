package com.example.fitnessapp.feature_app.presentation.AddAlarm

data class AddAlarmState(
    val sleep: String = "",
    val hours: String = "",
    val repeat: String = "",
    val isComplete: Boolean = false,
    val error: String = ""
)