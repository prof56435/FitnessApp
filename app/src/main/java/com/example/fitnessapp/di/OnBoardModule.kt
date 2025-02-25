package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.OnBoardRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.OnBoardRepository
import org.koin.dsl.module

val moduleOnBoard = module {
    single<OnBoardRepository> {
        OnBoardRepositoryImpl(get())
    }
}