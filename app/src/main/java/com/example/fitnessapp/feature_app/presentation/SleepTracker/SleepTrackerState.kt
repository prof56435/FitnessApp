package com.example.fitnessapp.feature_app.presentation.SleepTracker

import com.example.fitnessapp.feature_app.domain.model.Sleep

data class SleepTrackerState(
    val error: String = "",
    val name: String = "",
    val hours: String = ""
)