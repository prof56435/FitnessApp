package com.example.fitnessapp.feature_app.presentation.WelcomeScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.AddPrefUseCase
import com.example.fitnessapp.feature_app.domain.usecase.GetPrefUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeVM(
    private val getPrefUseCase: GetPrefUseCase,
    private val addPrefUseCase: AddPrefUseCase
): ViewModel() {
    private val _state = mutableStateOf(WelcomeState())
    val state: State<WelcomeState> = _state

    fun onEvent(event: WelcomeEvent){
        when(event){
            WelcomeEvent.GoNext ->{
                viewModelScope.launch {
                    delay(3000)
                    _state.value = state.value.copy(
                        next = true
                    )
                }
            }
        }
    }
}