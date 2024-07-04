package ru.aidar.clean_app.di.main

import ru.aidar.clean_app.di.deps.ComponentDependencies
import ru.aidar.clean_app.navigator.Navigator
import ru.aidar.menu_impl.LocalManager

interface MainDependencies : ComponentDependencies {

    fun navigator(): Navigator

    fun localManager(): LocalManager
}
