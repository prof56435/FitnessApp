package com.example.fitnessapp.feature_app.domain.usecase.Profile

import androidx.compose.ui.text.font.FontWeight
import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository

class AddProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(target: String, height: Int, weight: Int, years: Int){
        profileRepository.addProfile(target = target, height = height, weight = weight, years = years)
    }
}