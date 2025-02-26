package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.model.Profile

interface ProfileRepository {
    suspend fun addFioNumber(fio: String, number: String)
    suspend fun getName(): String
    suspend fun addProfile(target: String, height: Int, weight: Int, years: Int)
    suspend fun getProfile(): Profile
}