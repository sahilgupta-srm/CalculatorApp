package com.example.calculator1.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.calculator1.db.Calculator
import com.example.calculator1.db.CalculatorDao
import com.example.calculator1.db.CalculatorDataClass
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides

    fun provideEquationDataBase(context: Context):CalculatorDataClass{
        return Room.databaseBuilder(context,CalculatorDataClass::class.java,"Calulator_data_base")
            .build()
    }
    @Provides
    @Singleton
    fun provideCalculatorDao(calculatorDataClass: CalculatorDataClass):CalculatorDao{
        return calculatorDataClass.calculatordao()
    }
}