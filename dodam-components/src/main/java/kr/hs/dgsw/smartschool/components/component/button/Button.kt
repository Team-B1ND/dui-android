package kr.hs.dgsw.smartschool.components.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.foundation.ProvideTextStyle
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

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
    val color = when (type) {
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
    
    Surface(
        onClick = if (enable) onClick else null,
        modifier = modifier,
        shape = shape,
        color = color,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        ProvideTextStyle(value = DodamTheme.typography.label1) {
            Row(
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 15.dp,
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
}
