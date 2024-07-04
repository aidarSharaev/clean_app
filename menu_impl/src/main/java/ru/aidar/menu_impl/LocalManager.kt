package ru.aidar.menu_impl

import kotlinx.coroutines.flow.Flow

interface LocalManager {

    fun readAnimalFromStore(): Flow<String>

    suspend fun saveAnimalInStore(value: String)
}
