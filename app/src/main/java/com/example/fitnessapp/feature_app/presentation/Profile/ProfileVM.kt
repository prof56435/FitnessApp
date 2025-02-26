package com.example.fitnessapp.feature_app.presentation.Profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileVM(
    private val getProfileUseCase: GetProfileUseCase
): ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    fun onEvent(event: ProfileEvent){
        when(event){
            ProfileEvent.GetProfile->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val profile = getProfileUseCase.invoke()
                        _state.value = state.value.copy(
                            name = profile.fio,
                            target = profile.target,
                            height = profile.height,
                            weight = profile.weight,
                            years = profile.years
                        )
                    } catch (ex: Exception){
                        _state.value = state.value.copy(
                            error = ex.message.toString()
                        )
                    }
                }
            }
            ProfileEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}