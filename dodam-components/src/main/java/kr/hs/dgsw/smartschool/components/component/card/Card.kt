package kr.hs.dgsw.smartschool.components.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.badge.Badge
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcBreakfast3D
import kr.hs.dgsw.smartschool.components.theme.IcDinner3D
import kr.hs.dgsw.smartschool.components.theme.IcLunch3D
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.components.utlis.DodamString

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

private val MEAL_ICON_SIZE = 30.dp

@Composable
fun MealCard(
    content: String,
    mealType: MealType,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {

    val mealData: MealData = when (mealType) {
        MealType.BreakFast -> MealData(DodamString.Breakfast, DodamTheme.color.Breakfast) {
            IcBreakfast3D(
                modifier = Modifier.size(MEAL_ICON_SIZE),
                contentDescription = null
            )
        }
        MealType.Lunch -> MealData(DodamString.Lunch, DodamTheme.color.Lunch) {
            IcLunch3D(
                modifier = Modifier.size(MEAL_ICON_SIZE),
                contentDescription = null
            )
        }
        MealType.Dinner -> MealData(DodamString.Dinner, DodamTheme.color.Dinner) {
            IcDinner3D(
                modifier = Modifier.size(MEAL_ICON_SIZE),
                contentDescription = null
            )
        }
    }

    Box {
        Card(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 80.dp)
                .padding(top = 15.dp),
            shape = shape,
            background = background,
            rippleEnable = rippleEnable,
            rippleColor = rippleColor,
            bounded = bounded,
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = DodamDimen.CardSidePadding,
                        vertical = 24.dp
                    )
                    .fillMaxWidth()
            ) {
                Badge(
                    text = mealData.name,
                    background = mealData.badgeColor,
                    modifier = Modifier.align(Alignment.CenterVertically),
                )
                Spacer(modifier = Modifier.width(DodamDimen.CardSidePadding))
                Text(
                    text = content,
                    style = DodamTheme.typography.body3,
                    modifier = Modifier.align(Alignment.CenterVertically),
                )
            }
        }
        Box(modifier = Modifier.padding(start = 24.dp)) {
            mealData.icon()
        }
    }
}

private data class MealData(
    val name: String,
    val badgeColor: Color,
    val icon: @Composable () -> Unit
)
