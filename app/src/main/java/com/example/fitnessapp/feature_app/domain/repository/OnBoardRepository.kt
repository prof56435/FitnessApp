package com.example.fitnessapp.feature_app.domain.repository

//Назначение: репозиторий для сохранения и извлечения состояния OnBoard
//Дата: 25.02.2025
//Автор: Неробеев Алексей

interface OnBoardRepository {
    suspend fun getPref(): Int
    suspend fun addPref(number: Int)
}