package com.example.bmicalculator.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BMIMain(
    viewModel: BMIViewModel = viewModel(),
    navigateToResult: (String) -> Unit,
) {
    val (height, setHeight) = remember { mutableStateOf("") }
    val (weight, setWeight) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "BMI 계산기",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(20.dp))

        InPutField(label = "신장", value = height, onValueChange = setHeight, unit = "cm")
        Spacer(modifier = Modifier.height(20.dp))

        InPutField(label = "체중", value = weight, onValueChange = setWeight, unit = "kg")
        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = {
                viewModel.setBMI(height.toDouble(), weight.toDouble())
            }
        ) {
            Text(text = "확인하러가기")
        }
    }

    LaunchedEffect(viewModel.onClickEvent) {
        viewModel.onClickEvent.collect {
            navigateToResult(it)
        }
    }
}

@Composable
fun InPutField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
){
    Row {
        Text(
            text = label,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(16.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = "${label}을 입력 하세요") },
            singleLine = true,
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = unit,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}