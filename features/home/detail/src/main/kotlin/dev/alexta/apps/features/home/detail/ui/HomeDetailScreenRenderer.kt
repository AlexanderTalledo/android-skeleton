package dev.alexta.apps.features.home.detail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexta.apps.features.home.detail.presentation.HomeDetailViewModel
import dev.alexta.apps.shared.ui.domain.screens.ScreenRenderer

class HomeDetailScreenRenderer(
    private val onNavigateIconClicked: () -> Unit,
) : ScreenRenderer {

    @Composable
    override fun Render() = with(viewModel<HomeDetailViewModel>()) {
        val state by stateFlow.collectAsStateWithLifecycle()

        HomeDetailScreen(
            state = state,
            onNavigateIconClicked = onNavigateIconClicked,
        ).Display()
    }

}
