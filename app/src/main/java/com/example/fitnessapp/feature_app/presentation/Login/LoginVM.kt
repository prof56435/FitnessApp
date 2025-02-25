package com.example.fitnessapp.feature_app.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.feature_app.domain.usecase.Auth.AuthUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Auth.EmailValidationUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Auth.PasswordValidationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Назначение: ViewModel для экрана Login
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class LoginVM(
    private val authUseCase: AuthUseCase,
    private val emailValidationUseCase: EmailValidationUseCase,
    private val passwordValidationUseCase: PasswordValidationUseCase
): ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.EnterEmail->{
                _state.value = state.value.copy(
                    email = event.email
                )
            }
            is LoginEvent.EnterPassword->{
                _state.value = state.value.copy(
                    password = event.password
                )
            }
            LoginEvent.VisualChange->{
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
            LoginEvent.Auth->{
                if(emailValidationUseCase.invoke(state.value.email)){
                    if(passwordValidationUseCase.invoke(state.value.password)){
                        viewModelScope.launch(Dispatchers.IO) {
                            try {
                                authUseCase.invoke(state.value.email, state.value.password)
                                _state.value = state.value.copy(
                                    isComplete = true
                                )
                            } catch (ex: Exception){
                                _state.value = state.value.copy(
                                    error = ex.message.toString()
                                )
                            }
                        }
                    } else{
                        _state.value = state.value.copy(
                            error = "Пароль должен содержать не менее 6 символов"
                        )
                    }
                } else{
                    _state.value = state.value.copy(
                        error = "Некорректная почта"
                    )
                }
            }
            LoginEvent.ClearError->{
                _state.value = state.value.copy(
                    error = ""
                )
            }
        }
    }
}