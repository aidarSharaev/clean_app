package ru.aidar.app_common.base.local_manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.aidar.app_common.ext.PICKED_ANIMAL
import ru.aidar.app_common.ext.dataStore

interface LocalManager {

    fun readAnimalFromStore(): Flow<String>

    suspend fun saveAnimalInStore(value: String)
}

class LocalManagerImpl(val context: Context) : LocalManager {
    override fun readAnimalFromStore(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PICKED_ANIMAL] ?: "none"
        }
    }

    override suspend fun saveAnimalInStore(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PICKED_ANIMAL] = value
        }
    }
}
