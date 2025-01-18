package dev.alexta.apps.features.master.presentation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import app.cash.molecule.moleculeFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
internal class HomeMasterViewModel @Inject constructor() : ViewModel() {

    private val otpCodeFlow: Flow<String> = moleculeFlow(mode = RecompositionMode.Immediate) {
        var otpCode by remember { mutableStateOf("------") }

        LaunchedEffect(Unit) {
            while (true) {
                delay(3_000)

                otpCode = Random.nextInt(from = 100_000, until = 999_999).toString()
            }
        }

        otpCode
    }

    internal val stateFlow: StateFlow<HomeMasterState> = viewModelScope.launchMolecule(
        mode = RecompositionMode.Immediate,
    ) {
        HomeMasterState.create(
            optCodeFlow = otpCodeFlow,
        )
    }

}
