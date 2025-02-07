package dev.alexta.apps.features.home.master.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.alexta.apps.features.home.master.presentation.HomeMasterViewModel
import dev.alexta.apps.shared.ui.domain.renders.Renderable

class HomeMasterScreenRenderer(
    private val onNavigationIconClicked: () -> Unit,
) : Renderable {

    @Composable
    override fun Render() = with(hiltViewModel<HomeMasterViewModel>()) {
        val state by stateFlow.collectAsStateWithLifecycle()

        HomeMasterScreen(
            state = state,
            onNavigateIconClicked = onNavigationIconClicked,
        ).Render()
    }

}
