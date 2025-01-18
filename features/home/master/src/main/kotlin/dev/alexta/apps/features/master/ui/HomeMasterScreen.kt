package dev.alexta.apps.features.master.ui

import dev.alexta.apps.features.master.presentation.HomeMasterState
import dev.alexta.apps.shared.ui.contents.TotpContent
import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.contents.BottomBarContent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.domain.models.UiText
import dev.alexta.apps.shared.ui.screens.ScaffoldScreen

internal class HomeMasterScreen(state: HomeMasterState) : ScaffoldScreen() {

    override val topBar: TopBarContent? = null

    override val bottomBar: BottomBarContent? = null

    override val bodyContents: List<BodyContent> = listOf(
        TotpContent(
            otpCodeText = UiText.DynamicString(value = state.optCode)
        ),
    )

}
