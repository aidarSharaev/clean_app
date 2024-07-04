package ru.aidar.clean_app

import android.app.Application
import ru.aidar.app_common.di.CommonApi
import ru.aidar.app_common.di.FeatureContainer
import ru.aidar.clean_app.di.app.AppComponent
import ru.aidar.clean_app.di.deps.ComponentDependenciesProvider
import ru.aidar.clean_app.di.deps.FeatureHolderManager
import javax.inject.Inject

open class App : Application(), FeatureContainer {

    @Inject
    lateinit var dependencies: ComponentDependenciesProvider

    @Inject
    lateinit var featureHolderManager: FeatureHolderManager

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}

/**
 *
 * почему commonApi не модуль
 */
