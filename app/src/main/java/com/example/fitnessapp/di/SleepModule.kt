package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.SleepRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.SleepRepository
import com.example.fitnessapp.feature_app.domain.usecase.Sleep.AddSleepUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Sleep.GetSleepUseCase
import org.koin.dsl.module

val moduleSleep = module {
    single<SleepRepository> {
        SleepRepositoryImpl()
    }
    factory<AddSleepUseCase> {
        AddSleepUseCase(get())
    }
    factory<GetSleepUseCase> {
        GetSleepUseCase(get())
    }
}