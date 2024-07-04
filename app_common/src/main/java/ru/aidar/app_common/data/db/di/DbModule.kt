package ru.aidar.app_common.data.db.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.app_common.data.db.AppDatabase
import ru.aidar.app_common.data.db.dao.CatFactDao
import ru.aidar.app_common.scope.ApplicationScope

@Module
class DbModule {
    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }

    @Provides
    @ApplicationScope
    fun provideCatFactDao(appDatabase: AppDatabase): CatFactDao {
        return appDatabase.catFactDao()
    }
}
