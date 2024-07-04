package ru.aidar.menu_impl.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.app_common.scope.MenuScope
import ru.aidar.menu_impl.presentation.MenuFragment

@MenuScope
@Subcomponent(modules = [MenuModule::class])
interface MenuComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): MenuComponent
    }

    fun inject(fragment: MenuFragment)
}
