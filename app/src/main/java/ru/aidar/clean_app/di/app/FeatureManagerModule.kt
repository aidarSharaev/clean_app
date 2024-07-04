package ru.aidar.clean_app.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.app_common.di.FeatureApiHolder
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.di.deps.FeatureHolderManager

@Module
class FeatureManagerModule {
    @ApplicationScope
    @Provides
    fun provideHolderManager(featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}
