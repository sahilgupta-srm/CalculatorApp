package com.example.calculator1.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CalculatorSubComponent::class])
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return context.applicationContext

    }
}