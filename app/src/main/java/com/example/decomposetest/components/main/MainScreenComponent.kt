package com.example.decomposetest.components.main

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value
import com.example.decomposetest.components.dialog.DialogComponent
import com.example.decomposetest.components.main.left.variant1.LeftBoxComponentVariant1
import com.example.decomposetest.components.main.left.variant2.LeftBoxComponentVariant2
import kotlinx.coroutines.flow.Flow

interface MainScreenComponent {

    val data: Flow<String>
    val leftBox: Value<ChildSlot<*, LeftBoxChild>>
    val dialog: Value<ChildSlot<*, DialogChild>>

    fun showLeftContent()

    fun showDialog()

    sealed interface LeftBoxChild {
        data class Variant1(val component: LeftBoxComponentVariant1): LeftBoxChild
        data class Variant2(val component: LeftBoxComponentVariant2): LeftBoxChild
    }

    sealed interface DialogChild {
        data class DefaultDialog(val component: DialogComponent): DialogChild
    }
}