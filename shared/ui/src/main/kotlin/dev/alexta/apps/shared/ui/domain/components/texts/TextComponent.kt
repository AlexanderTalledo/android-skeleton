package dev.alexta.apps.shared.ui.domain.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.alexta.apps.shared.ui.domain.components.Component
import dev.alexta.apps.shared.ui.domain.models.UiText

internal sealed interface TextComponent : Component {

    data class TopBarTitle(
        private val text: UiText,
        private val modifier: Modifier = Modifier,
    ) : TextComponent {

        @Composable
        override fun Render() {
            Text(
                text = text.asString(),
                style = MaterialTheme.typography.titleLarge,
            )
        }

    }

}
