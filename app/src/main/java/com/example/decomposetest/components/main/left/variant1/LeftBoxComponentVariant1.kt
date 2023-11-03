package com.example.decomposetest.components.main.left.variant1

import org.orbitmvi.orbit.ContainerHost

interface LeftBoxComponentVariant1: ContainerHost<String, String>{
    fun onToastButtonClicked()
}