package ru.aidar.clean_app.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.App

@Module
class AppModule {
    @ApplicationScope
    @Provides
    fun provideContext(application: App): Context {
        return application
    }
}
