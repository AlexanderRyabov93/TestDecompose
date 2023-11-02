package com.example.decomposetest.components

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.decomposetest.components.main.MainScreenComponent
import com.example.decomposetest.components.tasks.TasksComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onClickBottomNavigation(index: Int)

    sealed interface Child {
        class MainScreen(val component: MainScreenComponent): Child
        class TasksScreen(val component: TasksComponent): Child
    }
}