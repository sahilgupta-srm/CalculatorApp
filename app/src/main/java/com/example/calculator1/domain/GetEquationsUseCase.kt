package com.example.calculator1.domain

import com.example.calculator1.db.Calculator
import com.example.calculator1.db.CalculatorLocalDataImpl

class GetEquationsUseCase(private val calculatorLocalDataImpl: CalculatorLocalDataImpl) {
    suspend fun getEquationFromDataBase():List<Calculator>? {

     return calculatorLocalDataImpl.getEquationFromDb()
    }
}