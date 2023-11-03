package com.example.decomposetest.components.main.left.variant1

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LeftBoxVariant1(component: LeftBoxComponentVariant1) {
    val context = LocalContext.current
    val state = component.collectAsState()
    component.collectSideEffect{
        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
    }
    Column {
        Text(text = state.value)
        Button(onClick = { component.onToastButtonClicked() }) {
            Text(text = "Show Toast")
        }
    }
    
    
}