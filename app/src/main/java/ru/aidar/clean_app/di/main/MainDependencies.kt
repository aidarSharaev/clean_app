package ru.aidar.clean_app.di.main

import ru.aidar.clean_app.di.deps.ComponentDependencies
import ru.aidar.clean_app.navigator.Navigator

interface MainDependencies : ComponentDependencies {
    fun navigator(): Navigator

}
