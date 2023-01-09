package kr.hs.dgsw.smartschool.components.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color

/**
 * @param onClick 클릭 됐을 때, 람다식 실행(null이라면 click 활성화를 하지 않음).
 * @param rippleColor ripple 색상을 지정
 * @param rippleEnable ripple 활성화 여부
 */
fun Modifier.dodamClickable(
    onClick: (() -> Unit)? = null,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true
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
