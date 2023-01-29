package kr.hs.dgsw.smartschool.components.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

@Composable
fun Card(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: @Composable () -> Unit
) {
    Surface(
        onClick = if (enable) onClick else null,
        modifier = modifier,
        shape = shape,
        color = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        content()
    }
}

sealed interface MealType {
    object BreakFast : MealType
    object Lunch : MealType
    object Dinner : MealType
}

@Composable
fun MealCard(
    content: String,
    mealType: MealType,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    hasLinkIcon: Boolean = false,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    titleStyle: TextStyle = DodamTheme.typography.title2,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {
    Card(
        onClick = if (enable) onClick else null,
        modifier = modifier.fillMaxWidth().height(96.dp),
        shape = shape,
        background = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 18.dp,
                    vertical = 18.dp
                )
                .fillMaxSize()
        ) {
            Text(
                text = content,
                style = titleStyle.copy(
                    color = contentColorFor(backgroundColor = background),
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                ),
                modifier = Modifier.weight(1f)
            )
            if (hasLinkIcon) {
                Spacer(modifier = Modifier.height(14.dp))
                IcRightArrow(
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.CenterVertically),
                    tint = DodamTheme.color.Gray400,
                    contentDescription = null
                )
            }
        }
    }
}
