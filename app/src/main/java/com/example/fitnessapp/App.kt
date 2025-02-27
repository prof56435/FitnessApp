package com.example.fitnessapp

import android.app.Application
import com.example.fitnessapp.di.moduleAuth
import com.example.fitnessapp.di.moduleOnBoard
import com.example.fitnessapp.di.moduleProfile
import com.example.fitnessapp.di.moduleSleep
import com.example.fitnessapp.di.moduleVM
import com.example.fitnessapp.di.moduleWorkout
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

//Назначение: объявление koin
//Дата: 25.02.2025
//Автор: Неробеев Алексей

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            androidLogger(Level.DEBUG)
            modules(
                moduleVM, moduleOnBoard, moduleAuth, moduleProfile, moduleWorkout, moduleSleep
            )
        }
    }
}