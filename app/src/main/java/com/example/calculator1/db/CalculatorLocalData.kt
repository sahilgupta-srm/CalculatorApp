package com.example.calculator1.db

interface CalculatorLocalData {
        suspend fun getEquationFromDb():List<Calculator>
        suspend fun saveEquationToDb(equation:Calculator)
        suspend fun clearALl()
    }
