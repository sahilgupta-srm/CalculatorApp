package com.example.calculator1.presentation.di

import com.example.calculator1.MainActivity
import dagger.Subcomponent
@CalculatorScope
@Subcomponent(modules = [CalculatorModule::class])
interface CalculatorSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():CalculatorSubComponent
    }
}