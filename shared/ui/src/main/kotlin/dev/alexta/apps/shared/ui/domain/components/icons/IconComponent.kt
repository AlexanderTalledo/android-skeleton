package dev.alexta.apps.shared.ui.domain.components.icons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import dev.alexta.apps.shared.ui.domain.components.Component
import dev.alexta.apps.shared.ui.domain.models.UiIcon
import dev.alexta.apps.shared.ui.domain.models.UiText

internal interface IconComponent : Component {

    data class Navigation(
        private val icon: UiIcon,
        private val onClick: () -> Unit,
        private val contentDescriptionText: UiText? = null,
    ) : IconComponent {

        @Composable
        override fun Render() {
            IconButton(onClick = onClick) {
                Icon(
                    painter = icon.asPainter(),
                    contentDescription = contentDescriptionText?.asString(),
                )
            }
        }

    }

}
