package dev.alexta.apps.shared.ui.domain.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.alexta.apps.shared.ui.domain.models.UiText
import dev.alexta.apps.shared.ui.domain.theme.ThemePaddings

internal sealed interface TextComponent : Component {

    data class Otp(
        private val codeText: UiText,
        private val modifier: Modifier = Modifier,
    ) : TextComponent {

        @[Composable OptIn(ExperimentalAnimationApi::class)]
        override fun Render() {
            var previousOtpCodeText by remember { mutableStateOf(codeText) }

            SideEffect {
                previousOtpCodeText = codeText
            }

            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(space = ThemePaddings.Small),
            ) {
                val codeString = codeText.asString()
                val previousCodeString = previousOtpCodeText.asString()

                for (i in codeString.indices) {
                    val codeDigit = codeString[i]
                    val previousCodeDigit = previousCodeString[i]
                    val newCodeDigit = if (codeDigit == previousCodeDigit) {
                        previousCodeDigit
                    } else {
                        codeDigit
                    }

                    Box(
                        modifier = Modifier
                            .width(
                                width = 48.dp,
                            )
                            .border(
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = Color.White,
                                ),
                                shape = RoundedCornerShape(
                                    size = ThemePaddings.Small,
                                ),
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        AnimatedContent(
                            targetState = newCodeDigit,
                            transitionSpec = {
                                slideInVertically(
                                    animationSpec = tween(durationMillis = 2_000)
                                ) { it } togetherWith slideOutVertically(
                                    animationSpec = tween(durationMillis = 2_000)
                                ) { -it }
                            }
                        ) { codeDigit ->
                            Text(
                                modifier = Modifier
                                    .padding(
                                        vertical = ThemePaddings.Medium,
                                    ),
                                text = codeDigit.toString(),
                                style = MaterialTheme.typography.titleLarge,
                                softWrap = false,
                            )
                        }
                    }
                }
            }
        }

    }

}
