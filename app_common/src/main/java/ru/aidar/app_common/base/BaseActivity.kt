package ru.aidar.app_common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel>() : AppCompatActivity() {
    @Inject
    protected open lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        // todo installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
        inject()
    }

    abstract fun inject()

    abstract fun initViews()

    abstract fun layoutResource(): Int
}
