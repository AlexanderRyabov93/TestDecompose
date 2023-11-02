package com.example.decomposetest.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.decomposetest.components.main.MainScreen
import com.example.decomposetest.components.tasks.Tasks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Root(rootComponent: RootComponent) {
        Scaffold(modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar {
                    (0..2).forEach {
                        NavigationBarItem(
                            icon = {},
                            label = { Text(it.toString()) },
                            selected = false,
                            onClick = {rootComponent.onClickBottomNavigation(it)}
                        )
                    }
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Children(modifier = Modifier.fillMaxSize(), stack = rootComponent.stack) { child ->
                    when (val instance = child.instance) {
                        is RootComponent.Child.MainScreen -> MainScreen(instance.component)
                        is RootComponent.Child.TasksScreen -> Tasks(instance.component)
                    }
                }
            }
        }

    }
