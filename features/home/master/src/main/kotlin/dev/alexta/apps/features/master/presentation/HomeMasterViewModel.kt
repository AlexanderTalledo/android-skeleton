package dev.alexta.apps.features.master.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
internal class HomeMasterViewModel @Inject constructor() : ViewModel() {

    internal val stateFlow: StateFlow<HomeMasterState> = viewModelScope.launchMolecule(
        mode = RecompositionMode.ContextClock,
    ) {
        HomeMasterState
    }

}
