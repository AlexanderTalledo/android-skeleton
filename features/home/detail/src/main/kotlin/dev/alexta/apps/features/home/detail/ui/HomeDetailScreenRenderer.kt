package dev.alexta.apps.features.home.detail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.alexta.apps.features.home.detail.presentation.HomeDetailViewModel
import dev.alexta.apps.shared.ui.domain.renders.Renderable

class HomeDetailScreenRenderer(
    private val onNavigateIconClicked: () -> Unit,
) : Renderable {

    @Composable
    override fun Render() = with(hiltViewModel<HomeDetailViewModel>()) {
        val state by stateFlow.collectAsStateWithLifecycle()

        HomeDetailScreen(
            state = state,
            onNavigateIconClicked = onNavigateIconClicked,
        ).Render()
    }

}
