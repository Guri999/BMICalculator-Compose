package com.example.bmicalculator.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.math.pow

class BMIViewModel: ViewModel() {
    private val _onClickEvent = MutableSharedFlow<String>()
    val onClickEvent = _onClickEvent.asSharedFlow()

    fun setBMI (height: Double, weight: Double) {
        viewModelScope.launch {
            _onClickEvent.emit(
                (weight / (height / 100).pow(2)).toString()
            )
        }
    }
}