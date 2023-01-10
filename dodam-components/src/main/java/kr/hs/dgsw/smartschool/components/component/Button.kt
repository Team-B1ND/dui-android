package kr.hs.dgsw.smartschool.components.component

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.foundation.ProvideTextStyle
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

sealed interface ButtonType {
    object Primary : ButtonType
    object Secondary : ButtonType
    object Danger : ButtonType
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
    enabled: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(15.dp),
    type: ButtonType = ButtonType.Primary,
    content: @Composable RowScope.() -> Unit,
) {
    val color = when (type) {
        ButtonType.Primary -> DodamTheme.color.MainColor
        ButtonType.Secondary -> DodamTheme.color.SecondaryColor
        ButtonType.Danger -> DodamTheme.color.Error
        ButtonType.Song -> DodamColor.FeatureColor.SongColor
        ButtonType.Schedule -> DodamColor.FeatureColor.ScheduleColor
        ButtonType.LostFound -> DodamColor.FeatureColor.LostFoundColor
        ButtonType.Itmap -> DodamColor.FeatureColor.ItMapColor
        ButtonType.MyInfo -> DodamColor.FeatureColor.MyInfoColor
    }
    
    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = color,
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
