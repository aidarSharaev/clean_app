package ru.aidar.app_common.data.db.di

import dagger.Component
import ru.aidar.app_common.di.CommonApi
import ru.aidar.app_common.scope.ApplicationScope

@ApplicationScope
@Component(
    modules = [DbModule::class],
    dependencies = [DbDependencies::class],
)
abstract class DbComponent : DbApi {
    @Component(dependencies = [CommonApi::class])
    interface DbDependenciesComponent : DbDependencies
}
