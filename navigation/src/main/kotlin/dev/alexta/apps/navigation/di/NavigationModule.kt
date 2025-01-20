package dev.alexta.apps.navigation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.alexta.apps.navigation.commands.InMemoryNavigationCommandHandler
import dev.alexta.apps.navigation.domain.commands.NavigationCommandHandler
import dev.alexta.apps.navigation.domain.destinations.NavigationDestination
import dev.alexta.apps.navigation.domain.graphs.home.HomeMasterNavigationDestination
import dev.alexta.apps.navigation.domain.graphs.home.HomeNavigationDestination
import dev.alexta.apps.navigation.domain.navigators.NavigationNavigator
import dev.alexta.apps.navigation.navigators.AppNavigationNavigator
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal abstract class NavigationModule {

    @[Binds Singleton]
    internal abstract fun bindNavigationNavigator(
        implementation: AppNavigationNavigator,
    ): NavigationNavigator

    @[Binds Singleton]
    internal abstract fun bindNavigationCommandHandler(
        implementation: InMemoryNavigationCommandHandler,
    ): NavigationCommandHandler

    internal companion object {

        @[Provides Singleton]
        internal fun provideStartNavigationDestination(): NavigationDestination = HomeNavigationDestination

    }

}
