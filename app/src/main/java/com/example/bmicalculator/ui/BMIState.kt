package com.example.bmicalculator.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

enum class BMIState(
    val info: String,
    var data: String? = null
) {
    UNDER(
        info = "저체중 입니다."
    ),STANDARD(
        info = "정상 체중 입니다."
    ),OVER(
        info = "과체중 입니다."
    ),OBESITY(
        info = "비만 입니다."
    ),SEVERE(
        info = "고도 비만 입니다."
    ),UNKNOWN(
        info = "제대로 된 값을 입력해 주세요.."
    )
    ;
}

sealed class Screen(val route: String) {
    object Main: Screen("main")
    object Result: Screen("result/{result}") {
        fun createRoute(result: String) = "result/$result"
    }
}