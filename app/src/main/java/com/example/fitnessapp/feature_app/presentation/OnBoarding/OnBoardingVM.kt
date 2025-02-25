package com.example.fitnessapp.feature_app.presentation.OnBoarding

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.OnBoard.AddPrefUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Назначение: ViewModel для экранов OnBoarding
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class OnBoardingVM(
    private val addPrefUseCase: AddPrefUseCase
): ViewModel() {
    private val _state = mutableStateOf(OnBoardingState())
    val state: State<OnBoardingState> = _state

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.GoNext->{
                viewModelScope.launch(Dispatchers.Main) {
                    addPrefUseCase.invoke(event.value + 1)
                }
                _state.value = state.value.copy(
                    next = true
                )
            }
            OnBoardingEvent.NotNext->{
                _state.value = state.value.copy(
                    next = false
                )
            }
            is OnBoardingEvent.SwipeChange->{
               _state.value = state.value.copy(
                   swipe = event.swipe
               )
                if (state.value.swipe <= -100){
                    viewModelScope.launch(Dispatchers.Main) {
                        addPrefUseCase.invoke(event.number + 1)
                    }
                    _state.value = state.value.copy(
                        next = true
                    )
                }
            }
            OnBoardingEvent.SwipeNull->{
                _state.value = state.value.copy(
                    swipe = 0f
                )
            }
        }
    }
}