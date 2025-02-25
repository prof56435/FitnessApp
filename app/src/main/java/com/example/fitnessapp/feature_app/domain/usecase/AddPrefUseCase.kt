package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository

class AddPrefUseCase(
    private val onBoardRepository: OnBoardRepository
) {
    suspend operator fun invoke(number: Int){
        onBoardRepository.addPref(number)
    }
}