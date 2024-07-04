package ru.aidar.app_common.data.db.di

import ru.aidar.app_common.data.db.AppDatabase

interface DbApi {
    fun provideDataBase(): AppDatabase
}
