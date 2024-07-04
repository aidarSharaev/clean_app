package ru.aidar.app_common.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.aidar.app_common.data.db.dao.CatFactDao

private const val DATABASE_NAME = "app.db"

abstract class AppDatabase : RoomDatabase() {
    companion object {
        fun get(context: Context): AppDatabase =
            Room
                .databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun catFactDao(): CatFactDao
}
