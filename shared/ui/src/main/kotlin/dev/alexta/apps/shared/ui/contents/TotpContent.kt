package dev.alexta.apps.shared.ui.contents

import androidx.compose.runtime.Composable
import dev.alexta.apps.shared.ui.domain.components.CodeComponent
import dev.alexta.apps.shared.ui.domain.contents.BodyContent
import dev.alexta.apps.shared.ui.domain.models.UiText

data class TotpContent(
    private val otpCodeText: UiText,
) : BodyContent() {

    @Composable
    override fun Show() {
        CodeComponent.Otp(
            codeText = otpCodeText,
        ).Render()
    }

}
