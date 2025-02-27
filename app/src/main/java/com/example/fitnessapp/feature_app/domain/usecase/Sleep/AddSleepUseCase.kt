package com.example.fitnessapp.feature_app.domain.usecase.Sleep

import com.example.fitnessapp.feature_app.domain.repository.SleepRepository

class AddSleepUseCase(
    private val sleepRepository: SleepRepository
) {
    suspend operator fun invoke(name: String, hours: String, repeat: String){
        sleepRepository.addSleep(name, hours, repeat)
    }
}