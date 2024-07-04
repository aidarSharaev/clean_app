package ru.aidar.menu_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.app_common.di.CommonApi
import ru.aidar.app_common.scope.FeatureScope
import ru.aidar.menu_impl.LocalManager
import ru.aidar.menu_impl.MenuRouter

@FeatureScope
@Component(
    dependencies = [MenuFeatureDependencies::class],
    modules = [MenuFeatureModule::class],
)
interface MenuFeatureComponent : MenuFeatureApi {
    fun menuComponentFactory(): MenuComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(menuRouter: MenuRouter): Builder

        @BindsInstance
        fun localManager(localManager: LocalManager): Builder

        fun withDependencies(deps: MenuFeatureDependencies): Builder

        fun build(): MenuFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
//            DbApi::class,
        ],
    )
    interface MenuFeatureDependenciesComponent : MenuFeatureDependencies
}
