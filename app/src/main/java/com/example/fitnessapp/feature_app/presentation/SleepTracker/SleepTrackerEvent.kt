package com.example.fitnessapp.feature_app.presentation.SleepTracker

import com.example.fitnessapp.feature_app.presentation.SleepSchedule.SleepScheduleEvent

sealed class SleepTrackerEvent {
    data object GetSleep: SleepTrackerEvent()
    data object ClearError: SleepTrackerEvent()
}