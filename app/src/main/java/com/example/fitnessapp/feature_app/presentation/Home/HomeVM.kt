package com.example.fitnessapp.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeVM(
    private val getNameUseCase: GetNameUseCase
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    fun onEvent(event: HomeEvent){
        when(event){
            HomeEvent.GetName->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        _state.value = state.value.copy(
                            name = getNameUseCase.invoke()
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            HomeEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}