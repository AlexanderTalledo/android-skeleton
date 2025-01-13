package dev.alexta.apps.features.home.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class HomeDetailViewModel @Inject constructor() : ViewModel() {

    internal val stateFlow: StateFlow<HomeDetailState> = viewModelScope.launchMolecule(
        mode = RecompositionMode.ContextClock,
    ) {
        HomeDetailState
    }

}
