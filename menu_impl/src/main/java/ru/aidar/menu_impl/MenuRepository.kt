package ru.aidar.menu_impl

import android.util.Log
import javax.inject.Inject

class MenuRepositoryImpl
    @Inject
    constructor() : MenuRepository {
        override fun log() {
            Log.d("animal", "MenuRepository.log()")
        }
    }

interface MenuRepository {
    fun log()
}
