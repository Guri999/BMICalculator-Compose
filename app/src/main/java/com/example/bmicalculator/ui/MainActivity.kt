package com.example.bmicalculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMICalculatorTheme {
                BMIApp()
            }
        }
    }
}

/*
* val navController = rememberNavController()
            val navGraph = navController.createGraph(
                startDestination = "Main"
            ) {
                composable(ScreenState.MAIN.name) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        BMIMain(viewModel)//별도의 클래스 파일을 만들어서 구현
                    }
                }
                composable(ScreenState.RESULT.name) {
                    BMIResult(viewModel) {
                        navController.navigate("Main")
                    }
                }
            }
            *
            * NavHost(navController = navController, graph = navGraph)

            LaunchedEffect(true) {
                viewModel.result.collect {
                    if (it != BMIState.UNKNOWN) navController.navigate(ScreenState.RESULT.name)
                }
            }
* */
