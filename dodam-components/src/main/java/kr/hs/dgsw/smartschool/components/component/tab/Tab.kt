package kr.hs.dgsw.smartschool.components.component.tab

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor

@Composable
fun RowScope.Tab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    val contentColor = if (selected) {
        DodamTheme.color.MainColor400
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
        Box(
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
            Column(modifier = Modifier.width(IntrinsicSize.Min)) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = text,
                    style = if (selected) selectedStyle else unSelectStyle,
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
}