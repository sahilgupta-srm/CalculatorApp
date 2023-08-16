package com.example.calculator1.domain

import com.example.calculator1.db.Calculator
import com.example.calculator1.db.CalculatorLocalDataImpl

class AddEquationUseCase(private val calculatorLocalDataImpl: CalculatorLocalDataImpl) {
    suspend fun addEquation(equation: Calculator)=calculatorLocalDataImpl.saveEquationToDb(equation)
}