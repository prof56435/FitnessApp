package com.example.fitnessapp.feature_app.presentation.RegisterPage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Auth.SignUpUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.AddFioNumberUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.AddProfileUseCase
import com.example.fitnessapp.feature_app.presentation.Login.LoginEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterPageVM(
    private val signUpUseCase: SignUpUseCase,
    private val addFioNumberUseCase: AddFioNumberUseCase,
    private val addProfileUseCase: AddProfileUseCase
): ViewModel() {
    private val _state = mutableStateOf(RegisterPageState())
    val state: State<RegisterPageState> = _state

    fun onEvent(event: RegisterPageEvent){
        when(event){
            is RegisterPageEvent.EnterFio->{
                _state.value = state.value.copy(
                    fio = event.value
                )
            }
            is RegisterPageEvent.EnterNumber->{
                _state.value = state.value.copy(
                    number = event.value
                )
            }
            is RegisterPageEvent.EnterEmail->{
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is RegisterPageEvent.EnterPassword->{
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            RegisterPageEvent.CheckChange->{
                _state.value = state.value.copy(
                    check = !state.value.check
                )
            }
            RegisterPageEvent.VisualChange->{
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
            RegisterPageEvent.SignUp->{
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        signUpUseCase.invoke(state.value.email, state.value.password)
                        addFioNumberUseCase.invoke(state.value.fio, state.value.number)
                        addProfileUseCase.invoke("Улучшить форму", 180, 65, 22)
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
            RegisterPageEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}