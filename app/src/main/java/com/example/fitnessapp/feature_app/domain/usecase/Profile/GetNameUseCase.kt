package com.example.fitnessapp.feature_app.domain.usecase.Profile

import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository

class GetNameUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): String{
        return profileRepository.getName()
    }
}