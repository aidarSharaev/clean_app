package ru.aidar.clean_app.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.navigator.AppRouter
import ru.aidar.clean_app.navigator.Navigator

@Module
class NavigationModule {

    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideRouter(navigator: Navigator): AppRouter = navigator
}
