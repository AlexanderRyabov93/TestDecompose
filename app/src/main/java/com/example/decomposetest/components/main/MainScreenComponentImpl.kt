package com.example.decomposetest.components.main

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.example.decomposetest.components.dialog.DialogComponentImpl
import com.example.decomposetest.components.main.left.variant1.LeftBoxComponentVariant1Impl
import com.example.decomposetest.components.main.left.variant2.LeftBoxComponentVariant2Impl
import com.example.decomposetest.data.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.parcelize.Parcelize

class MainScreenComponentImpl(
    componentContext: ComponentContext,
    repository: DataRepository,
    private val onNavigateToTasks: () -> Unit
) : MainScreenComponent, ComponentContext by componentContext {

    override val data: Flow<String> = repository.getData().map { it.toString() }

    private val leftSideNavigation = SlotNavigation<LeftSideConfig>()

    private val dialogNavigation = SlotNavigation<DialogConfig>()

    private var count = 0

    override val leftBox: Value<ChildSlot<*, MainScreenComponent.LeftBoxChild>> =
        childSlot(
            source = leftSideNavigation,
            key = "LeftBox",
            childFactory = ::child
        )

    override val dialog: Value<ChildSlot<*, MainScreenComponent.DialogChild>> =
        childSlot(
            source = dialogNavigation,
            key = "Dialog",
            childFactory = ::dialogChild
        )


    override fun showLeftContent() {
        when (count) {
            0 -> leftSideNavigation.activate(LeftSideConfig.LeftVariant1)
            1 -> leftSideNavigation.activate(LeftSideConfig.LeftVariant2)
            else -> leftSideNavigation.dismiss()
        }
        if (count < 2) count++
        else count = 0
    }

    override fun showDialog() {
        dialogNavigation.activate(DialogConfig.DefaultDialog)
    }

//    override fun onClickBottomNavigation(index: Int) {
//        when(index) {
//            0 -> leftSideNavigation.activate(LeftSideConfig.LeftVariant1)
//            1 -> leftSideNavigation.activate(LeftSideConfig.LeftVariant2)
//            else -> leftSideNavigation.dismiss()
//        }
//    }

    private fun dialogChild(
        config: DialogConfig,
        componentContext: ComponentContext
    ): MainScreenComponent.DialogChild = when (config) {
        DialogConfig.DefaultDialog -> MainScreenComponent.DialogChild.DefaultDialog(
            DialogComponentImpl(
                componentContext = componentContext,
                onDismiss = { dismissDialog() }
            ))
    }

    private fun dismissDialog() {
        dialogNavigation.dismiss()
    }

    private fun child(
        config: LeftSideConfig,
        componentContext: ComponentContext
    ): MainScreenComponent.LeftBoxChild =
        when (config) {
            LeftSideConfig.LeftVariant1 -> MainScreenComponent.LeftBoxChild.Variant1(
                LeftBoxComponentVariant1Impl(componentContext)
            )

            LeftSideConfig.LeftVariant2 -> MainScreenComponent.LeftBoxChild.Variant2(
                LeftBoxComponentVariant2Impl(
                    componentContext = componentContext,
                    onButtonClicked = onNavigateToTasks
                )
            )
        }

    @Parcelize
    private sealed interface LeftSideConfig : Parcelable {

        @Parcelize
        object LeftVariant1 : LeftSideConfig

        @Parcelize
        object LeftVariant2 : LeftSideConfig
    }

    @Parcelize
    private sealed interface DialogConfig : Parcelable {

        @Parcelize
        object DefaultDialog : DialogConfig

    }
}