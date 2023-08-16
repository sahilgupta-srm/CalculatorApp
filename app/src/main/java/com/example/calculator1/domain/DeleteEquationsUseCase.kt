package com.example.calculator1.domain

import com.example.calculator1.db.CalculatorLocalDataImpl

class DeleteEquationsUseCase(private val calculatorLocalDataImpl: CalculatorLocalDataImpl)  {
    suspend fun deleteEquation()=calculatorLocalDataImpl.clearALl()
}