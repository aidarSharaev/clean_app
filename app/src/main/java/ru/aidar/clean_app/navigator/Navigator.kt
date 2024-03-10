package ru.aidar.clean_app.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import ru.aidar.clean_app.R

interface AppRouter {

    fun navigateToCats()

    fun navigateToDogs()

    fun navigateUp()
}

class Navigator : AppRouter {

    private var gpNavController: NavController? = null

    fun attachNavController(
        navController: NavController,
        graph: NavGraph,
    ) {
        navController.setGraph(graph, null)
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
