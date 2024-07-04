package ru.aidar.menu_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.app_common.scope.FeatureScope
import ru.aidar.menu_impl.MenuRepository
import ru.aidar.menu_impl.MenuRepositoryImpl

@Module
class MenuFeatureModule {
    @FeatureScope
    @Provides
    fun provideMenuRepository(menuRepository: MenuRepositoryImpl): MenuRepository {
        return menuRepository
    }
}
