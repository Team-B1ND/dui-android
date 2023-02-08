package kr.hs.dgsw.smartschool.components.component.set.tab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor

@Composable
fun RowScope.Tab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showLabel: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
    selectedColor: Color = DodamTheme.color.MainColor400,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    val contentColor = if (selected) {
        selectedColor
    } else {
        DodamTheme.color.Gray400
    }

    val selectedStyle = DodamTheme.typography.label2

    val unSelectStyle = DodamTheme.typography.label2.copy(
        fontWeight = FontWeight.Normal
    )

    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Column(
            modifier = modifier
                .selectable(
                    selected = selected,
                    onClick = onClick,
                    enabled = true,
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = null,
                )
        ) {
            if (showLabel && (icon == null))
                LabelOnly(
                    text = text,
                    selected = selected,
                    selectedStyle = selectedStyle,
                    unSelectStyle = unSelectStyle
                )
            else if (!showLabel && (icon != null))
                IconOnly(icon = icon)
            else if (showLabel && icon != null)
                IconLabel(
                    icon = icon,
                    text = text,
                    selected = selected,
                    selectedStyle = selectedStyle,
                    unSelectStyle = unSelectStyle
                )
            if (selected) {
                Divider(
                    color = DodamColor.MainColor400,
                    thickness = 2.dp,
                )
            }
        }
    }
}

@Composable
private fun LabelOnly(
    text: String,
    selected: Boolean,
    selectedStyle: TextStyle,
    unSelectStyle: TextStyle,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = text,
            style = if (selected) selectedStyle else unSelectStyle,
        )
    }
}

@Composable
private fun IconOnly(
    icon: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 13.dp)
                .size(20.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            icon()
        }
    }
}

@Composable
private fun IconLabel(
    icon: @Composable () -> Unit,
    text: String,
    selected: Boolean,
    selectedStyle: TextStyle,
    unSelectStyle: TextStyle,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(7.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                icon()
            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = text,
                style =
                if (selected)
                    selectedStyle.copy(fontSize = 10.sp)
                else
                    unSelectStyle.copy(fontSize = 10.sp),
            )
        }
    }
}
