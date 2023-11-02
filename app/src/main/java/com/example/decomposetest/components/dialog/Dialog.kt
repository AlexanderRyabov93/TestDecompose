package com.example.decomposetest.components.dialog

import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DialogContent(component: DialogComponent) {
    AlertDialog(
        onDismissRequest = component::onDismissClicked,
        title = { Text(text = "Title") },
        text = { Text(text = "Message") },
        confirmButton = {
            TextButton(onClick = component::onDismissClicked) {
                Text("Dismiss")
            }
        },
        modifier = Modifier.width(300.dp),
    )
}