package dev.alexta.apps.shared.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.contents.BottomBarContent
import dev.alexta.apps.shared.ui.domain.contents.TopBarContent
import dev.alexta.apps.shared.ui.domain.screens.Screen
import dev.alexta.apps.shared.ui.domain.theme.ThemePaddings

abstract class ScaffoldScreen : Screen {

    protected abstract val topBar: TopBarContent?

    protected abstract val bottomBar: BottomBarContent?

    protected abstract val bodyContents: List<BodyContent>

    @Composable
    override fun Display() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                topBar?.Show()
            },
            bottomBar = {
                bottomBar?.Show()
            },
        ) { innerPaddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = ThemePaddings.Medium),
                contentPadding = innerPaddingValues,
            ) {
                items(bodyContents) { bodyContent ->
                    bodyContent.Show()
                }
            }
        }
    }

}
