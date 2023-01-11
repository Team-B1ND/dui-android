package kr.hs.dgsw.smartschool.components.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

sealed interface ButtonType {
    object Primary : ButtonType
    object Secondary : ButtonType
    object Danger : ButtonType
    object Disable: ButtonType

    object Song : ButtonType
    object Schedule : ButtonType
    object LostFound : ButtonType
    object Itmap : ButtonType
    object MyInfo : ButtonType
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = DodamTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    val color = backgroundColorFor(type)
    
    Surface(
        onClick = if (enable) onClick else null,
        modifier = modifier,
        shape = shape,
        color = color,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            iconLeft?.let {
                iconLeft()
                Spacer(modifier = Modifier.width(8.dp))
            }
            content()
            iconRight?.let {
                Spacer(modifier = Modifier.width(8.dp))
                iconRight()
            }
        }
    }
}

private val IconButtonSize = 50.dp

@Composable
fun IconButton(
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {
    val backgroundColor = backgroundColorFor(type)

    val iconColor = contentColorFor(backgroundColor = backgroundColor)
    
    CompositionLocalProvider(
        LocalContentColor provides iconColor
    ) {
        Layout(
            modifier = modifier.then(
                Modifier
                    .background(backgroundColor, CircleShape)
                    .clip(CircleShape)
                    .dodamClickable(
                        onClick = if (enable) onClick else null,
                        rippleEnable = rippleEnable,
                        rippleColor = rippleColor,
                        bounded = bounded
                    )
            ),
            content = icon
        ) { measurables, constraints ->
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            val boxWidth = IconButtonSize.toPx().toInt()
            val boxHeight = IconButtonSize.toPx().toInt()

            layout(boxWidth, boxWidth) {
                placeables.forEach { placeable ->
                    val x = boxWidth / 2 - placeable.width / 2
                    val y = boxHeight / 2 - placeable.height / 2
                    placeable.placeRelative(x = x, y = y)
                }
            }
        }
    }
}

@Composable
private fun backgroundColorFor(type: ButtonType): Color =
    when (type) {
        ButtonType.Primary -> DodamTheme.color.MainColor
        ButtonType.Secondary -> DodamTheme.color.SecondaryColor
        ButtonType.Danger -> DodamTheme.color.Error
        ButtonType.Disable -> DodamTheme.color.Gray100
        ButtonType.Song -> DodamColor.FeatureColor.SongColor
        ButtonType.Schedule -> DodamColor.FeatureColor.ScheduleColor
        ButtonType.LostFound -> DodamColor.FeatureColor.LostFoundColor
        ButtonType.Itmap -> DodamColor.FeatureColor.ItMapColor
        ButtonType.MyInfo -> DodamColor.FeatureColor.MyInfoColor
    }
