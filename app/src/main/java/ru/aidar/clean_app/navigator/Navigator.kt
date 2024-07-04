package ru.aidar.clean_app.navigator

import androidx.navigation.NavController
import ru.aidar.clean_app.R
import ru.aidar.menu_impl.MenuRouter

class Navigator : MenuRouter {

    private var gpNavController: NavController? = null

    fun attachNavController(
        navController: NavController,
        graph: Int,
    ) {
        navController.setGraph(graph)
        gpNavController = navController
    }

    fun detachNavController(navController: NavController) {
        if (gpNavController == navController) {
            gpNavController = null
        }
    }

    override fun navigateToCats() {
        gpNavController?.navigate(R.id.action_menuFragment_to_catFragment, null)
    }

    override fun navigateToDogs() {
        gpNavController?.navigate(R.id.action_menuFragment_to_dogFragment, null)
    }

    override fun navigateUp() {
        gpNavController?.popBackStack()
    }
}
