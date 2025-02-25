package com.example.fitnessapp.feature_app.domain.usecase

import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository

class GetPrefUseCase(
    private val onBoardRepository: OnBoardRepository
) {
    suspend operator fun invoke(): Int{
        return onBoardRepository.getPref()
    }
}