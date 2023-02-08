package kr.hs.dgsw.smartschool.components.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color

/**
 * @param onClick action when click, active lambda fun(if null non click).
 * @param rippleColor ripple color
 * @param rippleEnable ripple enabled
 */
fun Modifier.dodamClickable(
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: (() -> Unit)? = null,
) = composed {
    onClick?.let { onClick ->
        clickable(
            onClick = { onClick() },
            indication = if (rippleEnable)
                rememberRipple(
                    color = rippleColor,
                    bounded = bounded
                ) else null,
            interactionSource = remember { MutableInteractionSource() }
        )
    } ?: this
}
