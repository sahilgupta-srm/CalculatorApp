package com.example.calculator1.db

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorLocalDataImpl(private val calculatorDao: CalculatorDao) :CalculatorLocalData{
    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch{
            calculatorDao.deleteeqn()
        }
    }

    override suspend fun saveEquationToDb(equation: Calculator) {
        CoroutineScope(Dispatchers.IO).launch{
            calculatorDao.saveeqn(equation)
        }
    }

    override suspend fun getEquationFromDb(): List<Calculator> {
        var equationList:List<Calculator>
        try{
            equationList= calculatorDao.geteqn()
        }catch (exception:java.lang.Exception){
            Log.i("Mytag",exception.message.toString())
            equationList= listOf(
                Calculator(1,"1+1",2.0)//testing
            )
    }

        return equationList
}
}