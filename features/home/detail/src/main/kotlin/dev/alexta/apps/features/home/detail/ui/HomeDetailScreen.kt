package dev.alexta.apps.features.home.detail.ui

import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.contents.BottomBarContent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.screens.ScaffoldScreen
import javax.inject.Inject

class HomeDetailScreen @Inject constructor() : ScaffoldScreen() {

    override val topBar: TopBarContent? = null

    override val bottomBar: BottomBarContent? = null

    override val bodyContents: List<BodyContent> = emptyList()

}
