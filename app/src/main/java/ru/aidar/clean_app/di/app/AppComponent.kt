package ru.aidar.clean_app.di.app

import dagger.BindsInstance
import dagger.Component
import ru.aidar.app_common.di.CommonApi
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.App
import ru.aidar.clean_app.di.deps.ComponentDependenciesModule
import ru.aidar.clean_app.di.deps.ComponentHolderModule
import ru.aidar.clean_app.di.main.MainDependencies

// @Component
@Component(
    modules = [
        AppModule::class,
        LocalManagerModule::class,
        NavigationModule::class,
        FeatureManagerModule::class,
        ComponentHolderModule::class,
        ComponentDependenciesModule::class,
    ],
)
@ApplicationScope
interface AppComponent : CommonApi, MainDependencies {

    companion object {
        fun init(application: App): AppComponent {
            return DaggerAppComponent
                .builder()
                .application(application = application)
                .build()
        }
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
