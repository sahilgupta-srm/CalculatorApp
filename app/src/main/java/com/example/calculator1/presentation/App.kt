package com.example.calculator1.presentation

import android.app.Application
import com.example.calculator1.presentation.di.AppComponent
import com.example.calculator1.presentation.di.AppModule
import com.example.calculator1.presentation.di.CalculatorSubComponent
import com.example.calculator1.presentation.di.DaggerAppComponent
import com.example.calculator1.presentation.di.Injector
import dagger.Component

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }


    override fun createCalculatorSubComponent(): CalculatorSubComponent {
        return appComponent.calculatorSubComponent().create()
    }

}