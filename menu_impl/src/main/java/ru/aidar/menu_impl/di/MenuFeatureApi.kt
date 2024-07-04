package ru.aidar.menu_impl.di

import ru.aidar.menu_impl.MenuRepository

interface MenuFeatureApi {
    fun provideMenuRepository(): MenuRepository
}
