package com.example.fitnessapp.feature_app.domain.usecase.OnBoard

import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository

//Назначение: UseCase для вызова метода сохранения состояния OnBoard
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class AddPrefUseCase(
    private val onBoardRepository: OnBoardRepository
) {
    suspend operator fun invoke(number: Int){
        onBoardRepository.addPref(number)
    }
}