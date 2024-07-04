package ru.aidar.clean_app.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.navigator.Navigator
import ru.aidar.menu_impl.MenuRouter

@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideRouter(navigator: Navigator): MenuRouter = navigator
}
