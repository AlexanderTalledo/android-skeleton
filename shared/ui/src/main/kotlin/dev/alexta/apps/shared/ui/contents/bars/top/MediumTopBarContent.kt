package dev.alexta.apps.shared.ui.contents.bars.top

import androidx.compose.runtime.Composable
import dev.alexta.apps.shared.ui.domain.components.bars.top.TopBarComponent
import dev.alexta.apps.shared.ui.domain.components.icons.IconComponent
import dev.alexta.apps.shared.ui.domain.components.texts.TextComponent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.domain.models.UiIcon
import dev.alexta.apps.shared.ui.domain.models.UiText

data class MediumTopBarContent(
    private val titleText: UiText,
    private val navigationIcon: UiIcon? = null,
    private val onNavigationIconClick: () -> Unit = {},
) : TopBarContent() {

    @Composable
    override fun Show() {
        TopBarComponent.Medium(
            title = TextComponent.TopBarTitle(
                text = titleText,
            ),
            navigationIcon = navigationIcon?.let { icon ->
                IconComponent.Navigation(
                    icon = icon,
                    onClick = onNavigationIconClick,
                )
            }
        ).Render()
    }

}
