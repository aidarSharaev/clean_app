package ru.aidar.app_common.di

import android.content.Context
import ru.aidar.app_common.base.local_manager.LocalManager
import ru.aidar.app_common.config.AppProperties
import ru.aidar.app_common.data.network.NetworkApiCreator

interface CommonApi {
    fun applicationContext(): Context

//    fun provideNetworkApiCreator(): NetworkApiCreator
//
//    fun provideAppProperties(): AppProperties
}
