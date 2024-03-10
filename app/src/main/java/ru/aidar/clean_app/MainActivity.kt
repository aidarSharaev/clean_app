package ru.aidar.clean_app

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.aidar.app_common.base.BaseActivity
import ru.aidar.clean_app.di.deps.findComponentDependencies
import ru.aidar.clean_app.di.main.MainComponent
import ru.aidar.clean_app.navigator.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    lateinit var navigator: Navigator

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
    }

    override fun inject() {
       // MainComponent.init(this, findComponentDependencies()).inject(this)
    }

    override fun initViews() {
        navController = Navigation.findNavController(this, R.id.nav_graph)
        val navGraph = navController?.navInflater?.inflate(R.navigation.nav_graph)
        if(true) {
            navGraph?.setStartDestination(R.id.catFragment)
        }
        navigator.attachNavController(navController!!, navGraph!!)
    }

    override fun layoutResource() = R.layout.activity_main

    override fun onDestroy() {
        super.onDestroy()
        navController?.let {
            navigator.detachNavController(it)
        }
    }
}
