package com.example.fitnessapp.feature_app.presentation.SleepSchedule

import com.example.fitnessapp.feature_app.domain.model.Sleep

data class SleepScheduleState(
    val error: String = "",
    val name: String = "",
    val hours: String = ""
)