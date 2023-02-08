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

@Composable
fun BadgeBox(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    background: Color = DodamTheme.color.MainColor,
    shape: Shape = DodamTheme.shape.large,
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
