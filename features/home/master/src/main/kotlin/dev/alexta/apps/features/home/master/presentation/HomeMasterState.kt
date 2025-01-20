package dev.alexta.apps.features.home.master.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow

internal data class HomeMasterState(
    internal val optCode: String,
) {

    internal companion object {

        @Composable
        internal fun create(optCodeFlow: Flow<String>): HomeMasterState {
            val optCode by optCodeFlow.collectAsState(initial = "------")

            return HomeMasterState(
                optCode = optCode,
            )
        }

    }

}
