package com.example.decomposetest.components.main.left.variant1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun LeftBoxVariant1(component: LeftBoxComponentVariant1) {
    Text(text = component.data.collectAsState("").value)
}