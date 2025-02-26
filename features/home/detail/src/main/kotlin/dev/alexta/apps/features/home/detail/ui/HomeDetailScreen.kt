package dev.alexta.apps.features.home.detail.ui

import dev.alexta.apps.features.home.detail.R
import dev.alexta.apps.features.home.detail.presentation.HomeDetailState
import dev.alexta.apps.shared.ui.contents.bars.top.MediumTopBarContent
import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.contents.BottomBarContent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.domain.models.UiIcon
import dev.alexta.apps.shared.ui.domain.models.UiText
import dev.alexta.apps.shared.ui.domain.theme.ThemeIcons
import dev.alexta.apps.shared.ui.screens.ScaffoldScreen

internal class HomeDetailScreen(
    state: HomeDetailState,
    onNavigateIconClicked: () -> Unit,
) : ScaffoldScreen() {

    override val topBar: TopBarContent = MediumTopBarContent(
        titleText = UiText.Resource(
            resId = R.string.home_detail_top_bar_title,
        ),
        navigationIcon = UiIcon.Vector(
            imageVector = ThemeIcons.ArrowBack,
        ),
        onNavigationIconClick = onNavigateIconClicked
    )

    override val bottomBar: BottomBarContent? = null

    override val bodyContents: List<BodyContent> = emptyList()

}
