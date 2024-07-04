package ru.aidar.menu_impl.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.app_common.di.viewmodel.ViewModelKey
import ru.aidar.app_common.di.viewmodel.ViewModelModule
import ru.aidar.menu_impl.LocalManager
import ru.aidar.menu_impl.MenuRepository
import ru.aidar.menu_impl.MenuRouter
import ru.aidar.menu_impl.presentation.MenuViewModel

@Module(includes = [ViewModelModule::class])
class MenuModule {

    @Provides
    fun provideViewModel(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): MenuViewModel {
        return ViewModelProvider(fragment, factory)[MenuViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun provideMenuViewModel(
        localManager: LocalManager,
        router: MenuRouter,
        menuRepository: MenuRepository,
    ): ViewModel {
        return MenuViewModel(
            localManager = localManager,
            menuRouter = router,
            menuRepository = menuRepository,
        )
    }
}
