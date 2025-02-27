package com.example.fitnessapp.feature_app.presentation.AddAlarm

sealed class AddAlarmEvent {
    data class EnterSleep(val value: String): AddAlarmEvent()
    data class EnterHours(val value: String): AddAlarmEvent()
    data class EnterRepeat(val value: String): AddAlarmEvent()
    data object AddSleep: AddAlarmEvent()
    data object ClearError: AddAlarmEvent()
}