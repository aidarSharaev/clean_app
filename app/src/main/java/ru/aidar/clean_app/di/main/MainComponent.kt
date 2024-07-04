package ru.aidar.clean_app.di.main

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import ru.aidar.app_common.scope.FeatureScope
import ru.aidar.clean_app.MainActivity

@Component(
    dependencies = [MainDependencies::class],
    modules = [MainModule::class],
)
@FeatureScope
interface MainComponent {
    companion object {
        fun init(
            activity: AppCompatActivity,
            deps: MainDependencies,
        ): MainComponent {
            return DaggerMainComponent.factory().create(activity = activity, deps = deps)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: AppCompatActivity,
            deps: MainDependencies,
        ): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}
