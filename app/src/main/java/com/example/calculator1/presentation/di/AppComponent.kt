package com.example.calculator1.presentation.di

import com.example.calculator1.db.Calculator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[
    DataBaseModule::class,
LocalDataModule::class,
UseCaseModule::class,
AppModule::class,
])
interface AppComponent {
    fun calculatorSubComponent():CalculatorSubComponent.Factory

}