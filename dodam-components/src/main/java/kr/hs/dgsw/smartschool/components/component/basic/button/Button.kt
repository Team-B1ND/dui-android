package kr.hs.dgsw.smartschool.components.component.basic.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

sealed interface ButtonType {
    object Primary : ButtonType
    object PrimaryVariant : ButtonType
    object Secondary : ButtonType
    object SecondaryVariant : ButtonType
    object Danger : ButtonType
    object Disable : ButtonType
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
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            iconLeft?.let {
                iconLeft()
                Spacer(modifier = Modifier.width(8.dp))
            }
            Row(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                content()
            }

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

private val RadioButtonDotSize = 12.dp
private val StrokeWidth = 1.dp
private val RadioButtonSize = 20.dp

@Composable
fun RadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: ButtonType = ButtonType.PrimaryVariant,
) {
    val selectedColor = animateColorAsState(
        if (selected) backgroundColorFor(type) else DodamColor.Gray500
    )

    val dotRadius = animateDpAsState(
        targetValue = if (selected) RadioButtonDotSize / 2 else 0.dp,
        animationSpec = tween(durationMillis = 100)
    )

    val selectableModifier = if (onClick != null) {
        Modifier.selectable(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            role = Role.RadioButton,
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        )
    } else Modifier

    Canvas(
        modifier
            .then(selectableModifier)
            .wrapContentSize(Alignment.Center)
            .padding(2.dp)
            .requiredSize(RadioButtonDotSize)
    ) {
        val strokeWidth = StrokeWidth.toPx()

        // Outside Circle
        drawCircle(
            selectedColor.value,
            (RadioButtonSize / 2).toPx() - strokeWidth / 2, // 전체의 반 - 테두리 굵기 -> 반지름
            style = Stroke(strokeWidth)
        )

        // Insize Circle -> radius = dotRadius - 테두리 굵기
        if (dotRadius.value > 0.dp) {
            drawCircle(selectedColor.value, dotRadius.value.toPx() - strokeWidth / 2, style = Fill)
        }
    }
}

@Composable
private fun backgroundColorFor(type: ButtonType): Color =
    when (type) {
        ButtonType.Primary -> DodamTheme.color.MainColor
        ButtonType.PrimaryVariant -> DodamTheme.color.MainColor400
        ButtonType.Secondary -> DodamTheme.color.SecondaryColor
        ButtonType.SecondaryVariant -> DodamTheme.color.SecondaryColor400
        ButtonType.Danger -> DodamTheme.color.Error
        ButtonType.Disable -> DodamTheme.color.Gray100
        ButtonType.Song -> DodamColor.FeatureColor.SongColor
        ButtonType.Schedule -> DodamColor.FeatureColor.ScheduleColor
        ButtonType.LostFound -> DodamColor.FeatureColor.LostFoundColor
        ButtonType.Itmap -> DodamColor.FeatureColor.ItMapColor
        ButtonType.MyInfo -> DodamColor.FeatureColor.MyInfoColor
    }

@Composable
fun Color.buttonTypeFor(): ButtonType =
    when (this) {
        DodamTheme.color.MainColor -> ButtonType.Primary
        DodamTheme.color.MainColor400 -> ButtonType.PrimaryVariant
        DodamTheme.color.SecondaryColor -> ButtonType.Secondary
        DodamTheme.color.SecondaryColor400 -> ButtonType.SecondaryVariant
        DodamTheme.color.Error -> ButtonType.Danger
        DodamTheme.color.Gray100 -> ButtonType.Disable
        DodamColor.FeatureColor.SongColor -> ButtonType.Song
        DodamColor.FeatureColor.ScheduleColor -> ButtonType.Schedule
        DodamColor.FeatureColor.LostFoundColor -> ButtonType.LostFound
        DodamColor.FeatureColor.ItMapColor -> ButtonType.Itmap
        DodamColor.FeatureColor.MyInfoColor -> ButtonType.MyInfo
        else -> ButtonType.Primary
    }
