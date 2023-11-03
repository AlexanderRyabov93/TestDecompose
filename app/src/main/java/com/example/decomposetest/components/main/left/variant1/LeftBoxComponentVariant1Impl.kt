package com.example.decomposetest.components.main.left.variant1

import com.arkivanov.decompose.ComponentContext
import com.example.decomposetest.utils.coroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class LeftBoxComponentVariant1Impl(
    componentContext: ComponentContext,
): LeftBoxComponentVariant1, ComponentContext by componentContext {

    override val container: Container<String, String> = coroutineScope().container("Variant 1")

    override fun onToastButtonClicked() {
        intent{
            postSideEffect("Test toast")
        }
    }
}