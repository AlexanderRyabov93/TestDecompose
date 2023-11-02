package com.example.decomposetest.components.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun Tasks(component: TasksComponent) {
    Column {
        Text(text = component.data.collectAsState("").value)
        Text(text = component.argument)
    }
   
}