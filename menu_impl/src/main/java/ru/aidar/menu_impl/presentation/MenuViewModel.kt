package ru.aidar.menu_impl.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.aidar.app_common.base.BaseViewModel
import ru.aidar.app_common.base.ScreenState
import ru.aidar.menu_impl.LocalManager
import ru.aidar.menu_impl.MenuRepository
import ru.aidar.menu_impl.MenuRouter

class MenuViewModel(
    private val menuRepository: MenuRepository,
    private val localManager: LocalManager,
    private val menuRouter: MenuRouter,
) : BaseViewModel() {

    private val _menuFlow = MutableStateFlow(MenuState())
    val menuFlow = _menuFlow.asStateFlow().value

    private fun updateSelectedAnimal(animal: String) {
        _menuFlow.update { it.copy(selectedAnimal = animal) }
    }

    private fun updateScreenState(screenState: ScreenState) {
        _menuFlow.update { it.copy(screenState = screenState) }
    }

    init {
        viewModelScope.launch {
            fetchAnimalFromStore()
            Log.d("animal", "changeDestination")
            changeDestination()
        }
    }

    fun log() {
        menuRepository.log()
    }

    private fun changeDestination() {
        updateScreenState(ScreenState.Success)
        when (menuFlow.selectedAnimal) {
            "dog" -> {
                menuRouter.navigateToDogs()
            }

            "cat" -> {
                menuRouter.navigateToCats()
            }

            else -> {}
        }
    }

    private suspend fun fetchAnimalFromStore() {
        withContext(Dispatchers.IO) {
            val selectedAnimal =
                localManager
                    .readAnimalFromStore()
                    .first()
            updateSelectedAnimal(animal = selectedAnimal)
            delay(1_000)
            Log.d("animal", "withContext(Dispatchers.IO)")
        }
        Log.d("animal", "fetchAnimalFromStore")
    }

    fun saveSelectedAnimal(animal: String) {
        viewModelScope.launch(Dispatchers.Default) {
            localManager.saveAnimalInStore(value = animal)
        }
    }
}

data class MenuState(
    val selectedAnimal: String = "none",
    val screenState: ScreenState = ScreenState.Execution,
)

/*
fun String.changeRouter(animal: String, navigateTo: (String) -> Unit) {

}*/
