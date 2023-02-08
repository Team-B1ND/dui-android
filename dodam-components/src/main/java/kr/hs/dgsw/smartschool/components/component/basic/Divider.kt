package kr.hs.dgsw.smartschool.components.component.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor

/**
 * Divider
 *
 * @param modifier modifier
 * @param color Color of Divider / recommend Gray200
 * @param thickness width of Divider / basic 1.dp
 * @param startIndent start padding
 */
@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    val indentMod = if (startIndent.value != 0f) {
        Modifier.padding(start = startIndent)
    } else {
        Modifier
    }
    val targetThickness = if (thickness == Dp.Hairline) {
        (1f / LocalDensity.current.density).dp
    } else {
        thickness
    }
    Box(
        modifier
            .then(indentMod)
            .fillMaxWidth()
            .height(targetThickness)
            .background(color = color)
    )
}
