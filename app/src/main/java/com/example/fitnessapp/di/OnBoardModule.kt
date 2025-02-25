package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.OnBoardRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository
import com.example.fitnessapp.feature_app.domain.usecase.OnBoard.AddPrefUseCase
import com.example.fitnessapp.feature_app.domain.usecase.OnBoard.GetPrefUseCase
import org.koin.dsl.module

//Назначение: Создание модуля для OnBoardRepository
//Дата: 25.02.2025
//Автор: Неробеев Алексей

val moduleOnBoard = module {
    single<OnBoardRepository> {
        OnBoardRepositoryImpl(get())
    }
    factory<GetPrefUseCase> {
        GetPrefUseCase(get())
    }
    factory<AddPrefUseCase> {
        AddPrefUseCase(get())
    }
}