package com.example.fitnessapp.feature_app.data.repositoryImpl

import android.content.Context
import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository

//Написание логики для RepositoryImpl
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class OnBoardRepositoryImpl(context: Context): OnBoardRepository {
    val sharedPreferences = context.getSharedPreferences("OnBoardPrefs", 0)

    override suspend fun getPref(): Int {
        return sharedPreferences.getInt("OnBoard", 0)
    }

    override suspend fun addPref(number: Int) {
        sharedPreferences.edit().putInt("OnBoard", number).apply()
    }
}