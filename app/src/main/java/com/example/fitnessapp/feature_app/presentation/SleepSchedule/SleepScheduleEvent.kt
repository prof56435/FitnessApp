package com.example.fitnessapp.feature_app.presentation.SleepSchedule

sealed class SleepScheduleEvent {
    data object GetSleep: SleepScheduleEvent()
    data object ClearError: SleepScheduleEvent()
}