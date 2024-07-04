package ru.aidar.clean_app

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.aidar.app_common.base.BaseActivity
import ru.aidar.clean_app.di.deps.findComponentDependencies
import ru.aidar.clean_app.di.main.MainComponent
import ru.aidar.clean_app.navigator.Navigator
import ru.aidar.menu_impl.LocalManager
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var localManager: LocalManager

    private var navController: NavController? = null

    override fun inject() {
        MainComponent.init(this, findComponentDependencies()).inject(this)
    }

    override fun initViews() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment).navController
        navigator.attachNavController(navController!!, R.navigation.nav_graph)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.let {
            navigator.detachNavController(it)
        }
    }
}
