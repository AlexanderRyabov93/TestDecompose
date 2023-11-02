package com.example.decomposetest.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Этот репозиторий просто производит данные, увеличивая раз в 2 секунды число на 1. Нужен только для того, чтобы показать как
// компоненты могут взаимодействовать с остальными слоями приложения.
class DataRepository {

    private val someData = MutableStateFlow(0)

    init {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(2000)
                someData.value = someData.value + 1
            }
        }
    }

    fun getData(): StateFlow<Int> = someData
}