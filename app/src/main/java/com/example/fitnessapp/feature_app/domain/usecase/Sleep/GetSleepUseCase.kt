package com.example.fitnessapp.feature_app.domain.usecase.Sleep

import com.example.fitnessapp.feature_app.domain.model.Sleep
import com.example.fitnessapp.feature_app.domain.repository.SleepRepository

class GetSleepUseCase(
    private val sleepRepository: SleepRepository
) {
    suspend operator fun invoke(): Sleep{
        return sleepRepository.getSleep()
    }
}