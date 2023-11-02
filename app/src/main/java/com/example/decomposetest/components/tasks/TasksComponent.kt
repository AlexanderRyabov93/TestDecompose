package com.example.decomposetest.components.tasks

import kotlinx.coroutines.flow.Flow

interface TasksComponent {
    val data: Flow<String>
    val argument: String
}