package com.example.decomposetest.components.tasks

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TasksComponentImpl(
    componentContext: ComponentContext,
    override val argument: String,
): TasksComponent, ComponentContext by componentContext {
    override val data: Flow<String> = MutableStateFlow("Tasks")
}