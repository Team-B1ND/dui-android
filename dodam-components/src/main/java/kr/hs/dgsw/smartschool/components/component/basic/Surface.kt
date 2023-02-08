package kr.hs.dgsw.smartschool.components.component.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.semantics
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

/**
 * Dodam Clickable Surface
 *
 * @param onClick action when click surface
 * @param modifier
 * @param shape shape of surface basic is RectangleShape
 * @param color color of surface basic is white
 * @param contentColor color of composable contents in surface
 * @param rippleColor
 * @param rippleEnable
 * @param bounded
 * @param content composable content in surface
 */
@Composable
fun Surface(
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = DodamTheme.color.White,
    contentColor: Color = contentColorFor(color),
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Box(
            modifier = modifier
                .surface(
                    shape = shape,
                    backgroundColor = color,
                )
                .dodamClickable(
                    onClick = onClick,
                    rippleColor = rippleColor,
                    rippleEnable = rippleEnable,
                    bounded = bounded
                ),
        ) {
            content()
        }
    }
}

/**
 * Dodam Basic Surface
 *
 * @param modifier
 * @param shape shape of surface basic is RectangleShape
 * @param color color of surface basic is white
 * @param contentColor color of composable contents in surface
 * @param content composable content in surface
 */
@Composable
fun Surface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = DodamTheme.color.White,
    contentColor: Color = contentColorFor(color),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
    ) {
        Box(
            modifier = modifier
                .surface(
                    shape = shape,
                    backgroundColor = color
                )
                .semantics(mergeDescendants = false) {}
                .pointerInput(Unit) {},
            propagateMinConstraints = true
        ) {
            content()
        }
    }
}

fun Modifier.surface(
    shape: Shape,
    backgroundColor: Color,
) = this
    .background(color = backgroundColor, shape = shape)
    .clip(shape)
