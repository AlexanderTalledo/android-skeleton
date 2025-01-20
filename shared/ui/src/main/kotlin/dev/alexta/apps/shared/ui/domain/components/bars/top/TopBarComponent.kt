package dev.alexta.apps.shared.ui.domain.components.bars.top

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.alexta.apps.shared.ui.domain.components.Component
import dev.alexta.apps.shared.ui.domain.components.icons.IconComponent
import dev.alexta.apps.shared.ui.domain.components.texts.TextComponent

internal sealed interface TopBarComponent : Component {

    data class Medium(
        private val title: TextComponent.TopBarTitle,
        private val navigationIcon: IconComponent.Navigation? = null,
        private val modifier: Modifier = Modifier,
    ) : TopBarComponent {

        @[Composable OptIn(ExperimentalMaterial3Api::class)]
        override fun Render() {
            MediumTopAppBar(
                modifier = modifier,
                title = {
                    title.Render()
                },
                navigationIcon = {
                    navigationIcon?.Render()
                },
            )
        }

    }

}
