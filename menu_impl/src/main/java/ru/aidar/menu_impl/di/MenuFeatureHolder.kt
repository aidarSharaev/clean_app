package ru.aidar.menu_impl.di

import ru.aidar.app_common.di.FeatureApiHolder
import ru.aidar.app_common.di.FeatureContainer
import ru.aidar.app_common.scope.ApplicationScope
import ru.aidar.menu_impl.LocalManager
import ru.aidar.menu_impl.MenuRouter
import javax.inject.Inject

@ApplicationScope
class MenuFeatureHolder
    @Inject
    constructor(
        featureContainer: FeatureContainer,
        private val menuRouter: MenuRouter,
        private val localManager: LocalManager,
    ) : FeatureApiHolder(featureContainer) {
        override fun initializeDependencies(): Any {
            val menuFeatureDependencies =
                DaggerMenuFeatureComponent_MenuFeatureDependenciesComponent.builder()
                    .commonApi(commonApi())
                    .build()
            return DaggerMenuFeatureComponent.builder()
                .withDependencies(menuFeatureDependencies)
                .router(menuRouter)
                .localManager(localManager)
                .build()
        }
    }
