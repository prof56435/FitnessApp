package com.example.fitnessapp.feature_app.presentation.AddAlarm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Sleep.AddSleepUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.getScopeName

class AddAlarmVM(
    private val addSleepUseCase: AddSleepUseCase
) : ViewModel() {
    private val _state = mutableStateOf(AddAlarmState())
    val state: State<AddAlarmState> = _state

    fun onEvent(event: AddAlarmEvent) {
        when (event) {
            is AddAlarmEvent.EnterSleep -> {
                _state.value = state.value.copy(
                    sleep = event.value
                )
            }

            is AddAlarmEvent.EnterHours -> {
                _state.value = state.value.copy(
                    hours = event.value
                )
            }

            is AddAlarmEvent.EnterRepeat -> {
                _state.value = state.value.copy(
                    repeat = event.value
                )
            }

            AddAlarmEvent.ClearError -> {
                _state.value = state.value.copy(
                    error = ""
                )
            }

            AddAlarmEvent.AddSleep -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        if (state.value.sleep.isNotEmpty() &&
                            state.value.hours.isNotEmpty() &&
                            state.value.repeat.isNotEmpty()
                        ) {
                            addSleepUseCase.invoke(
                                state.value.sleep,
                                state.value.hours,
                                state.value.repeat
                            )
                            _state.value = state.value.copy(
                                isComplete = true
                            )
                        } else{
                            _state.value = state.value.copy(
                                error = "Все поля должны быть заполнены!"
                            )
                        }
                    } catch (ex: Exception) {
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
        }
    }
}