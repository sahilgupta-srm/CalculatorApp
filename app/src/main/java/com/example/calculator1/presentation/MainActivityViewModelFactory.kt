package com.example.calculator1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calculator1.domain.AddEquationUseCase
import com.example.calculator1.domain.DeleteEquationsUseCase
import com.example.calculator1.domain.GetEquationsUseCase

class MainActivityViewModelFactory(
    private val addEquationUseCase: AddEquationUseCase,
    private val deleteEquationsUseCase: DeleteEquationsUseCase,
    private val getEquationsUseCase: GetEquationsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(addEquationUseCase,deleteEquationsUseCase,getEquationsUseCase) as T
    }
}