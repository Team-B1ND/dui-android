package kr.hs.dgsw.smartschool.components.component.basic.badge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

/**
 * Dodam Badge Box, can contain composable contents
 *
 * @param modifier
 * @param background color of badge
 * @param shape shape of badge, basic is large
 * @param onClick when click badge
 * @param contentPaddingValues content Padding
 * @param rippleColor
 * @param rippleEnable
 * @param bounded
 * @param content composable contents
 */
@Composable
fun BadgeBox(
    modifier: Modifier = Modifier,
    background: Color = DodamTheme.color.MainColor,
    shape: Shape = DodamTheme.shape.large,
    onClick: (() -> Unit)? = null,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = 10.dp, vertical = 3.dp),
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: @Composable () -> Unit,
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Box(
            modifier = Modifier
                .padding(contentPaddingValues)
        ) {
            content()
        }
    }
}
