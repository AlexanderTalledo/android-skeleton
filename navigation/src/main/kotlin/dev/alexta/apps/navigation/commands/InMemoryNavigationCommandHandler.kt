package dev.alexta.apps.navigation.commands

import androidx.navigation.NavHostController
import dev.alexta.apps.navigation.domain.commands.NavigationCommand
import dev.alexta.apps.navigation.domain.commands.NavigationCommandHandler
import javax.inject.Inject

internal class InMemoryNavigationCommandHandler @Inject constructor() : NavigationCommandHandler {

    override fun handle(
        command: NavigationCommand,
        navController: NavHostController,
    ) {
        when (command) {
            is NavigationCommand.NavigateTo -> {
                navController.navigate(route = command.destination)
            }

            NavigationCommand.NavigateUp -> {
                navController.navigateUp()
            }
        }
    }
}
