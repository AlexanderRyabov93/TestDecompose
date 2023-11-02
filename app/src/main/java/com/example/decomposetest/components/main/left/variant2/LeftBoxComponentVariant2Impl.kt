package com.example.decomposetest.components.main.left.variant2

import com.arkivanov.decompose.ComponentContext

class LeftBoxComponentVariant2Impl(
    componentContext: ComponentContext,
    private val onButtonClicked: () -> Unit
): LeftBoxComponentVariant2, ComponentContext by componentContext {
    override fun onClickButton() {
        onButtonClicked()
    }

}