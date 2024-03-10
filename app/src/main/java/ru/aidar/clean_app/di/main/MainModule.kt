package ru.aidar.clean_app.di.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.app_common.base.local_manager.LocalManager
import ru.aidar.app_common.di.viewmodel.ViewModelKey
import ru.aidar.app_common.di.viewmodel.ViewModelModule
import ru.aidar.clean_app.MainViewModel

@Module(includes = [ViewModelModule::class])
class MainModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideViewModel(localManager: LocalManager): ViewModel {
        return MainViewModel(localManager = localManager)
    }

    @Provides
    fun provideViewModelCreator(
        activity: AppCompatActivity,
        viewModelFactory: ViewModelProvider.Factory,
    ): MainViewModel {
        //return View.of(activity, viewModelFactory)[MainViewModel::class.java]
        return ViewModelProvider(activity, viewModelFactory)[MainViewModel::class.java]
    }
}
