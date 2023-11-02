package com.example.decomposetest.components.main.left

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.decomposetest.components.main.MainScreenComponent
import com.example.decomposetest.components.main.left.variant1.LeftBoxVariant1
import com.example.decomposetest.components.main.left.variant2.LeftBoxVariant2

@Composable
fun LeftBox(
    modifier: Modifier = Modifier,
    contentType: MainScreenComponent.LeftBoxChild?
) {
    Box(modifier = modifier) {
        when (contentType) {
            is MainScreenComponent.LeftBoxChild.Variant1 -> LeftBoxVariant1(contentType.component)
            is MainScreenComponent.LeftBoxChild.Variant2 -> LeftBoxVariant2(contentType.component)
            else -> {}
        }
    }

}