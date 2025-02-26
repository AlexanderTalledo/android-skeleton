package dev.alexta.apps.navigation.domain.commands

import androidx.navigation.NavHostController

internal interface NavigationCommandHandler {

    fun handle(command: NavigationCommand, navController: NavHostController)

}
