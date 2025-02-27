package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.model.Sleep

interface SleepRepository {
    suspend fun addSleep(name: String, hours: String, repeat: String)
    suspend fun getSleep(): Sleep
}