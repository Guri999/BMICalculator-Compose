package com.example.bmicalculator.ui.result

data class ResultUiState(
    val title: String = "당신의 BMI 계산 결과는?",
    val result: String,
    val info: String,
    val buttonTitle: String = "돌아가기",
)