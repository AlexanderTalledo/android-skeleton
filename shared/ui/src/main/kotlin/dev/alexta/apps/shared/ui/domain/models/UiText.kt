package dev.alexta.apps.shared.ui.domain.models

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.stringResource

sealed class UiText {

    @Composable
    internal abstract fun asString(): String

    @Stable
    class Dynamic(private val value: String) : UiText() {

        @Composable
        override fun asString(): String = value

    }

    @Stable
    class Resource(
        @StringRes private val resId: Int,
        private vararg val args: Any = emptyArray(),
    ) : UiText() {

        @Composable
        override fun asString(): String = stringResource(
            id = resId,
            formatArgs = args,
        )

    }

}
