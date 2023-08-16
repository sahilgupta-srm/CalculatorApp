package com.example.calculator1.presentation.di

import com.example.calculator1.domain.AddEquationUseCase
import com.example.calculator1.domain.DeleteEquationsUseCase
import com.example.calculator1.domain.GetEquationsUseCase
import com.example.calculator1.presentation.MainActivityViewModel
import com.example.calculator1.presentation.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CalculatorModule {
    @CalculatorScope
    @Provides
    fun provideCalculatorViewModelFactory(addEquationUseCase: AddEquationUseCase,deleteEquationsUseCase: DeleteEquationsUseCase,getEquationsUseCase: GetEquationsUseCase):MainActivityViewModelFactory{
        return MainActivityViewModelFactory(addEquationUseCase,deleteEquationsUseCase,getEquationsUseCase)
    }

}