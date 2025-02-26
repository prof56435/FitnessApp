package com.example.fitnessapp.di

import com.example.fitnessapp.feature_app.data.repositoryImpl.ProfileRepositoryImpl
import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository
import com.example.fitnessapp.feature_app.domain.usecase.Profile.AddFioNumberUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.AddProfileUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetNameUseCase
import com.example.fitnessapp.feature_app.domain.usecase.Profile.GetProfileUseCase
import org.koin.dsl.module

val moduleProfile = module {
    single<ProfileRepository> {
        ProfileRepositoryImpl()
    }
    factory<AddFioNumberUseCase> {
        AddFioNumberUseCase(get())
    }
    factory<GetNameUseCase> {
        GetNameUseCase(get())
    }
    factory<AddProfileUseCase> {
        AddProfileUseCase(get())
    }
    factory<GetProfileUseCase> {
        GetProfileUseCase(get())
    }
}