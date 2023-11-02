package com.example.decomposetest.components.main.left.variant2

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun LeftBoxVariant2(component: LeftBoxComponentVariant2) {
   Button(onClick = {component.onClickButton()}) {
       Text(text = "Open tasks")
   }
}