package com.example.decomposetest.components.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.example.decomposetest.components.dialog.DialogContent
import com.example.decomposetest.components.main.left.LeftBox


@Composable
fun MainScreen(component: MainScreenComponent) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val state = component.data.collectAsState("")
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = state.value
        )
        LeftBox(
            modifier = Modifier.align(Alignment.CenterStart),
            contentType = component.leftBox.subscribeAsState().value.child?.instance
        )
        component.dialog.subscribeAsState().value.child?.instance?.let {
            when(it) {
                is MainScreenComponent.DialogChild.DefaultDialog -> DialogContent(it.component)
            }
        }
        ButtonsColumn(
            modifier = Modifier.align(Alignment.CenterEnd),
            onClickFirst = component::showLeftContent,
            onClickSecond = component::showDialog
        )

    }

}

@Composable
private fun ButtonsColumn(
    modifier: Modifier = Modifier,
    onClickFirst: () -> Unit,
    onClickSecond: () -> Unit
) {
    Column(modifier = modifier) {
        Button(onClick = onClickFirst) {
            Text(text = "Button 1")
        }
        Button(onClick = onClickSecond) {
            Text(text = "Button 2")
        }
    }
}