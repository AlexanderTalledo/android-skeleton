package dev.alexta.apps.navigation.navigators

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.alexta.apps.navigation.domain.commands.NavigationCommandHandler
import dev.alexta.apps.navigation.domain.destinations.NavigationDestination
import dev.alexta.apps.navigation.domain.graphs.home.homeNavigationGraph
import dev.alexta.apps.navigation.domain.navigators.NavigationNavigator
import javax.inject.Inject

internal class AppNavigationNavigator @Inject constructor(
    private val startDestination: NavigationDestination,
    private val navigationCommandHandler: NavigationCommandHandler,
) : NavigationNavigator {

    @Composable
    override fun NavGraphs(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
        ) {
            homeNavigationGraph { navCommand ->
                navigationCommandHandler.handle(navCommand, navController)
            }
        }
    }

}
