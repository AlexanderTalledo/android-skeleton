package dev.alexta.apps.shared.ui.domain.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.alexta.apps.shared.ui.domain.theme.ThemePaddings

internal sealed interface ContainerComponent : Component {

    class VerticalList(
        private val components: List<Component>,
        private val modifier: Modifier = Modifier,
        private val contentPadding: PaddingValues = PaddingValues(all = ThemePaddings.None),
    ) : ContainerComponent {

        @Composable
        override fun Render() {
            LazyColumn(
                modifier = modifier,
                contentPadding = contentPadding,
            ) {
                items(components) { component ->
                    component.Render()
                }
            }
        }

    }

}
