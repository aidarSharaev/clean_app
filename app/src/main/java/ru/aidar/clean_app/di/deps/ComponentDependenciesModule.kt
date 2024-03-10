package ru.aidar.clean_app.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.aidar.clean_app.di.app.AppComponent
import ru.aidar.clean_app.di.main.MainDependencies

@Module
interface ComponentDependenciesModule {
    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    fun provideMainDependencies(component: AppComponent): ComponentDependencies
}
