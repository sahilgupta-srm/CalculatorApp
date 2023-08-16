package com.example.calculator1.presentation.di

import com.example.calculator1.db.CalculatorDao
import com.example.calculator1.db.CalculatorLocalDataImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideCalculatorDataBaseSource(calculatorDao: CalculatorDao):CalculatorLocalDataImpl{
        return CalculatorLocalDataImpl(calculatorDao)
    }
}