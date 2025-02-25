package com.example.fitnessapp.feature_app.domain.repository

interface OnBoardRepository {
    suspend fun getPref(): Int
    suspend fun addPref(number: Int)
}