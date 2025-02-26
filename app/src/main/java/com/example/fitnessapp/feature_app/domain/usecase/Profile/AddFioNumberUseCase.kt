package com.example.fitnessapp.feature_app.domain.usecase.Profile

import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository

class AddFioNumberUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(fio: String, number: String){
        profileRepository.addFioNumber(fio = fio, number = number)
    }
}