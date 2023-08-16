package com.example.calculator1.presentation

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.*
import com.example.calculator1.db.Calculator
import com.example.calculator1.domain.AddEquationUseCase
import com.example.calculator1.domain.DeleteEquationsUseCase
import com.example.calculator1.domain.GetEquationsUseCase
import com.notkamui.keval.Keval
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(
    private val addEquationUseCase: AddEquationUseCase,
    private val deleteEquationsUseCase: DeleteEquationsUseCase,
    private val getEquationsUseCase: GetEquationsUseCase
):ViewModel() {
    private val current_Input = MutableLiveData<String>()//for equation
    val currentInput: LiveData<String>
        get() = current_Input

    private val current_ans=MutableLiveData<Double>()
    val currentAns:LiveData<Double>
        get()=current_ans


    fun onDigitClick(digit: Int) {
        val currentValue = current_Input.value ?: ""
        val updatedValue = currentValue + digit.toString()
        current_Input.value = updatedValue
        total()
    }

    fun onOperationClicked(operation: Char) {
        val currentValue = current_Input.value
        val updatedValue = when {
            currentValue.isNullOrEmpty() -> ""
            currentValue.lastOrNull()?.isDigit() == true -> currentValue + operation
            currentValue.lastOrNull() == '.' -> error("Wrong syntax,complete digit after decimal")
            currentValue.lastOrNull() == ')' -> currentValue + operation
            else -> currentValue.dropLast(1) + operation
        }
        current_Input.value = updatedValue
    }
    fun total(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = Keval.eval(current_Input.value ?: "")
            withContext(Dispatchers.Main) {
                current_ans.value = result
        }
        }
    }
    @SuppressLint("NullSafeMutableLiveData")
    fun saveDatatoDatabase(){
        val equation= current_ans.value?.let {
            Calculator(0,current_Input.value.toString(),
                it.toDouble())
        }
        if (equation != null) {
            viewModelScope.launch {
            addEquationUseCase.addEquation(equation)
        }}
        current_Input.value= currentAns.value.toString()
        current_ans.value=null




    }

    fun getEquations():LiveData<List<Calculator>?> = liveData {
        Log.i("Mytag","fn is called")
        viewModelScope.launch(Dispatchers.IO) {
            val equationlist = getEquationsUseCase.getEquationFromDataBase()
            emit(equationlist)
        }
    }

}






