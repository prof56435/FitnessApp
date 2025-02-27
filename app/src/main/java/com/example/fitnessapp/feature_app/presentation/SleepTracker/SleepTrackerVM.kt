package com.example.fitnessapp.feature_app.presentation.SleepTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Sleep.GetSleepUseCase
import com.example.fitnessapp.feature_app.presentation.SleepSchedule.SleepScheduleEvent
import com.example.fitnessapp.feature_app.presentation.SleepSchedule.SleepScheduleState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SleepTrackerVM(
    private val getSleepUseCase: GetSleepUseCase
): ViewModel() {
    private val _state = mutableStateOf(SleepTrackerState())
    val state: State<SleepTrackerState> = _state

    fun onEvent(event: SleepTrackerEvent){
        when(event){
            SleepTrackerEvent.GetSleep->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        _state.value = state.value.copy(
                            name = getSleepUseCase.invoke().name,
                            hours = getSleepUseCase.invoke().hours
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            SleepTrackerEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}