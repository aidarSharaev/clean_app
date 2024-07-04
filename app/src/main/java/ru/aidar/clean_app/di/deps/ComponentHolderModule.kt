package ru.aidar.clean_app.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.aidar.app_common.di.FeatureApiHolder
import ru.aidar.app_common.di.FeatureContainer
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.clean_app.App
import ru.aidar.menu_impl.di.MenuFeatureApi
import ru.aidar.menu_impl.di.MenuFeatureHolder

@Module
interface ComponentHolderModule {
    @Binds
    @ApplicationScope
    fun provideFeatureContainer(application: App): FeatureContainer

    @ApplicationScope
    @Binds
    @ClassKey(MenuFeatureApi::class)
    @IntoMap
    fun providesMenuFeatureHolder(menuFeatureHolder: MenuFeatureHolder): FeatureApiHolder
}
