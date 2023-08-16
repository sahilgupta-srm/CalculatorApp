package com.example.calculator1.presentation.di

import com.example.calculator1.db.CalculatorLocalDataImpl
import com.example.calculator1.domain.AddEquationUseCase
import com.example.calculator1.domain.DeleteEquationsUseCase
import com.example.calculator1.domain.GetEquationsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    fun provideAddEquationUseCase(calculatorLocalDataImpl: CalculatorLocalDataImpl):AddEquationUseCase{
        return AddEquationUseCase(calculatorLocalDataImpl)
    }

    @Provides
    fun provideDeleteEquationUseCase(calculatorLocalDataImpl: CalculatorLocalDataImpl):DeleteEquationsUseCase{
        return DeleteEquationsUseCase(calculatorLocalDataImpl)
    }
    @Provides
    fun provideGetEquationUseCase(calculatorLocalDataImpl: CalculatorLocalDataImpl):GetEquationsUseCase{
        return GetEquationsUseCase(calculatorLocalDataImpl)
    }
}