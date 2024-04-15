package com.example.bmicalculator.ui.result

import androidx.lifecycle.ViewModel
import com.example.bmicalculator.ui.BMIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResultViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<ResultUiState?>(null)
    val uiState = _uiState.asStateFlow()

    fun setUi(result: Double) {
        when {
            result >= 35 -> BMIState.SEVERE
            result >= 30 -> BMIState.OBESITY
            result >= 23 -> BMIState.OVER
            result >= 18.5 -> BMIState.STANDARD
            result < 18.5 -> BMIState.UNDER
            else -> BMIState.UNKNOWN
        }.apply {
            data = String.format("%.1f", result)
        }.let { bmi ->
            _uiState.value = ResultUiState(
                result = bmi.data?: "",
                info = bmi.info
            )
        }
    }
}