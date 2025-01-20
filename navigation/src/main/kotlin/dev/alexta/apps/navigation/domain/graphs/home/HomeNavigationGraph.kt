package dev.alexta.apps.navigation.domain.graphs.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.alexta.apps.features.home.detail.ui.HomeDetailScreenRenderer
import dev.alexta.apps.features.home.master.ui.HomeMasterScreenRenderer
import dev.alexta.apps.navigation.domain.commands.NavigationCommand

internal fun NavGraphBuilder.homeNavigationGraph(
    onNavigate: (NavigationCommand) -> Unit,
) {
    navigation<HomeNavigationDestination>(startDestination = HomeMasterNavigationDestination) {
        composable<HomeMasterNavigationDestination> {
            HomeMasterScreenRenderer(
                onNavigationIconClicked = {
                    NavigationCommand.NavigateTo(
                        destination = HomeDetailNavigationDestination,
                    ).also(onNavigate)
                }
            ).Render()
        }

        composable<HomeDetailNavigationDestination> {
            HomeDetailScreenRenderer(
                onNavigateIconClicked = {
                    NavigationCommand.NavigateUp.also(onNavigate)
                }
            ).Render()
        }
    }
}
