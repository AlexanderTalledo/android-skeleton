package dev.alexta.apps.features.home.master.ui

import dev.alexta.apps.features.home.master.R
import dev.alexta.apps.features.home.master.presentation.HomeMasterState
import dev.alexta.apps.shared.ui.contents.TotpContent
import dev.alexta.apps.shared.ui.contents.bars.top.MediumTopBarContent
import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.contents.BottomBarContent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.domain.models.UiIcon
import dev.alexta.apps.shared.ui.domain.models.UiText
import dev.alexta.apps.shared.ui.domain.theme.ThemeIcons
import dev.alexta.apps.shared.ui.screens.ScaffoldScreen

internal class HomeMasterScreen(
    state: HomeMasterState,
    onNavigateIconClicked: () -> Unit,
) : ScaffoldScreen() {

    override val topBar: TopBarContent = MediumTopBarContent(
        titleText = UiText.Resource(
            resId = R.string.home_master_top_bar_title,
        ),
        navigationIcon = UiIcon.Vector(
            imageVector = ThemeIcons.ArrowBack,
        ),
        onNavigationIconClick = onNavigateIconClicked
    )

    override val bottomBar: BottomBarContent? = null

    override val bodyContents: List<BodyContent> = listOf(
        TotpContent(
            otpCodeText = UiText.Dynamic(value = state.optCode)
        ),
    )

}
