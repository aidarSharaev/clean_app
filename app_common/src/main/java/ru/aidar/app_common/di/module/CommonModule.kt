package ru.aidar.app_common.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.app_common.base.local_manager.LocalManager
import ru.aidar.app_common.base.local_manager.LocalManagerImpl
import ru.aidar.app_common.config.AppProperties
import ru.aidar.app_common.scope.ApplicationScope

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideAppProperties(context: Context): AppProperties {
        return AppProperties(context)
    }

    @Provides
    @ApplicationScope
    fun provideLocalManager(context: Context): LocalManager {
        return LocalManagerImpl(context)
    }
}
