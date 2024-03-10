package ru.aidar.clean_app

import ru.aidar.app_common.base.BaseViewModel
import ru.aidar.app_common.base.local_manager.LocalManager

class MainViewModel(
    private val localManager: LocalManager,
) : BaseViewModel() {
    private suspend fun k(){
        localManager.saveAnimalInStore("kk")
    }
}
