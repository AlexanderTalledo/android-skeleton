package dev.alexta.apps.shared.ui.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource

sealed class UiIcon {

    @Composable
    internal abstract fun asPainter(): Painter

    @Stable
    data class Resource(@DrawableRes private val resId: Int) : UiIcon() {

        @Composable
        override fun asPainter(): Painter = painterResource(id = resId)

    }

    @Stable
    data class Vector(private val imageVector: ImageVector) : UiIcon() {

        @Composable
        override fun asPainter(): Painter = rememberVectorPainter(image = imageVector)

    }

}
