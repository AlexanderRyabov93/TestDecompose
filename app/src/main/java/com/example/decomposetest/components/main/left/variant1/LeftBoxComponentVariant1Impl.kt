package com.example.decomposetest.components.main.left.variant1

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LeftBoxComponentVariant1Impl(
    componentContext: ComponentContext,
): LeftBoxComponentVariant1, ComponentContext by componentContext {
    override val data: Flow<String> = MutableStateFlow("Variant 1")
}