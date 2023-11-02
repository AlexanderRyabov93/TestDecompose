package com.example.decomposetest.components.dialog

import com.arkivanov.decompose.ComponentContext

class DialogComponentImpl(
    componentContext: ComponentContext,
    private val onDismiss: () -> Unit
): DialogComponent, ComponentContext by componentContext {

    override fun onDismissClicked() {
        onDismiss()
    }
}