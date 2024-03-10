package ru.aidar.clean_app

import android.app.Application
import ru.aidar.clean_app.di.app.AppComponent
import ru.aidar.clean_app.di.deps.ComponentDependenciesProvider
import javax.inject.Inject

open class App : Application() {
    @Inject
    lateinit var dependencies: ComponentDependenciesProvider

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

//    override fun commonApi(): CommonApi {
//        return appComponent
//    }
}

/**
 *
 * почему commonApi не модуль
 */
