package com.example.fitnessapp.feature_app.presentation.SleepSchedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitnessapp.feature_app.domain.usecase.Sleep.GetSleepUseCase
import com.example.fitnessapp.feature_app.presentation.AddAlarm.AddAlarmEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

class SleepScheduleVM(
    private val getSleepUseCase: GetSleepUseCase
): ViewModel() {
    private val _state = mutableStateOf(SleepScheduleState())
    val state: State<SleepScheduleState> = _state

    fun onEvent(event: SleepScheduleEvent){
        when(event){
            SleepScheduleEvent.GetSleep->{
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
            SleepScheduleEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}