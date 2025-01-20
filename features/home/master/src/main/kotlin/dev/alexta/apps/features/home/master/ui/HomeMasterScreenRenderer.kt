package dev.alexta.apps.features.home.master.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexta.apps.features.home.master.presentation.HomeMasterViewModel
import dev.alexta.apps.shared.ui.domain.screens.ScreenRenderer

class HomeMasterScreenRenderer(
    private val onNavigationIconClicked: () -> Unit,
) : ScreenRenderer {

    @Composable
    override fun Render() = with(viewModel<HomeMasterViewModel>()) {
        val state by stateFlow.collectAsStateWithLifecycle()

        HomeMasterScreen(
            state = state,
            onNavigateIconClicked = onNavigationIconClicked,
        ).Display()
    }

}
