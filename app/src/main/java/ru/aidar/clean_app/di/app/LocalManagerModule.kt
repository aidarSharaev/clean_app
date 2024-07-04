package ru.aidar.clean_app.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.manager.LocalManagerImpl
import ru.aidar.menu_impl.LocalManager

@Module
class LocalManagerModule {

    @ApplicationScope
    @Provides
    fun provideLocalManagerImpl(context: Context): LocalManagerImpl {
        return LocalManagerImpl(context = context)
    }

    @ApplicationScope
    @Provides
    fun provideDataStore(localManagerImpl: LocalManagerImpl): LocalManager {
        return localManagerImpl
    }
}
