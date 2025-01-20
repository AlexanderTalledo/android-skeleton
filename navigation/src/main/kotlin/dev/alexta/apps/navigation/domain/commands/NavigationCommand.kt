package dev.alexta.apps.navigation.domain.commands

import dev.alexta.apps.navigation.domain.destinations.NavigationDestination

internal sealed interface NavigationCommand {

    data class NavigateTo(internal val destination: NavigationDestination) : NavigationCommand

    data object NavigateUp : NavigationCommand

}
