package com.example.fitnessapp.feature_app.domain.usecase.Profile

import com.example.fitnessapp.feature_app.domain.model.Profile
import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Profile {
        return profileRepository.getProfile()
    }
}