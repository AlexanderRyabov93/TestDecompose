package com.example.decomposetest.components

import android.os.Parcelable
import android.util.Log
import androidx.compose.ui.graphics.vector.RootGroupName
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.example.decomposetest.components.main.MainScreenComponent
import com.example.decomposetest.components.main.MainScreenComponentImpl
import com.example.decomposetest.components.tasks.TasksComponentImpl
import com.example.decomposetest.data.DataRepository
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

class RootComponentImpl(
    componentContext: ComponentContext,
    private val repository: DataRepository
) :RootComponent, ComponentContext by componentContext {

    init {

        Log.d("AAAAAAAAAA", "INIT")
    }

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.Main, // The initial child component is List
        handleBackButton = true, // Automatically pop from the stack on back button presses
        childFactory = ::child,
    )

    override fun onClickBottomNavigation(index: Int) {
       when(index){
           0 -> navigation.bringToFront(Config.Main)
           1 -> navigation.bringToFront(Config.Tasks("Open from bottom"))
       }
    }

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.Main -> RootComponent.Child.MainScreen(mainScreenComponent(componentContext, repository))
            is Config.Tasks -> RootComponent.Child.TasksScreen(TasksComponentImpl(
                componentContext = componentContext,
                argument = config.text
            ))
        }

    private fun mainScreenComponent(componentContext: ComponentContext, repository: DataRepository): MainScreenComponent =
        MainScreenComponentImpl(
            componentContext = componentContext,
            repository = repository,
            onNavigateToTasks = {navigation.bringToFront(Config.Tasks("Open from button"))}
        )



    @Parcelize
    private sealed interface Config: Parcelable {

        @Parcelize
        object Main: Config

        @Parcelize
        data class Tasks(val text: String): Config
    }

}