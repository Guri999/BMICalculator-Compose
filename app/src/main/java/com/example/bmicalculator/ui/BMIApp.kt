package com.example.bmicalculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.main.BMIMain
import com.example.bmicalculator.ui.result.BMIResult

@Composable
fun BMIApp(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
    ){
        composable(Screen.Main.route){
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                BMIMain{ data ->
                    navController.navigate(Screen.Result.createRoute(data))
                }
            }
        }

        composable(Screen.Result.route) { backStackEntry ->
            BMIResult(
                backStackEntry = backStackEntry
            ) {
                navController.navigate(Screen.Main.route)
            }
        }
    }
}