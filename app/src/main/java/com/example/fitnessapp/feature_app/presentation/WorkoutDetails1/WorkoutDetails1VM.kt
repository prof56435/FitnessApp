package com.example.fitnessapp.feature_app.presentation.WorkoutDetails1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Workout.CompleteWorkoutUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Workout.GetWorkoutUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutDetails1VM(
    private val getWorkoutUseCase: GetWorkoutUseCase,
    private val completeWorkoutUseCase: CompleteWorkoutUseCase
): ViewModel() {
    private val _state = mutableStateOf(WorkoutDetails1State())
    val state: State<WorkoutDetails1State> = _state

    fun onEvent(event: WorkoutDetails1Event){
        when(event){
            WorkoutDetails1Event.GetWorkout->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val workout = getWorkoutUseCase.invoke()
                        _state.value = state.value.copy(
                            name = workout.name,
                            description = workout.description,
                            hard = workout.hard
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            WorkoutDetails1Event.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
            WorkoutDetails1Event.CompleteWorkout->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        completeWorkoutUseCase.invoke(state.value.name, "Выполнено")
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
        }
    }
}