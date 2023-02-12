package kr.hs.dgsw.smartschool.components.component.set.appbar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcBackArrow
import kr.hs.dgsw.smartschool.components.theme.IcDelete
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

/**
 * Dodam top app bar, navigation and guide
 *
 * @param onStartIconClick action when click start icon
 * @param modifier modifier
 * @param backgroundColor color of background
 * @param startIcon icon placed start, if null place basic back arrow icon, recommend null
 * @param endContents end composable contents in row scope
 * @param title title left to start icon, recommend null
 * @param titleStyle text style to title
 */
@Composable
fun DodamAppBar(
    onStartIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = DodamTheme.color.White,
    startIcon: (@Composable () -> Unit)? = null,
    endContents: (@Composable RowScope.() -> Unit)? = null,
    title: String? = null,
    titleStyle: TextStyle = DodamTheme.typography.title2.copy(fontWeight = FontWeight.Medium),
) {
    Row(
        modifier = modifier
            .background(color = backgroundColor)
            .fillMaxWidth()
            .height(DodamDimen.AppBarHeight)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = DodamDimen.AppBarDefaultContentSpace)
                .dodamClickable(rippleEnable = false) {
                    onStartIconClick()
                },
            contentAlignment = Alignment.Center
        ) {
            startIcon?.let {
                it()
            } ?: IcBackArrow(
                modifier = Modifier
                    .size(DodamDimen.AppBarDefaultIconSize),
                tint = DodamTheme.color.Black,
                contentDescription = null,
            )
        }
        title?.let {
            Text(
                text = it,
                style = titleStyle,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        endContents?.let {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = DodamDimen.AppBarDefaultContentSpace)
                    .weight(1f),
                horizontalArrangement = Arrangement.End,
            ) {
                it()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDodamAppBar() {
    Column {
        DodamAppBar(
            onStartIconClick = { Log.d("PreviewAppBarTest", "Click!") },
            title = "알림",
            endContents = { AppBarSampleEndContents() }
        )
    }
}

@Composable
private fun RowScope.AppBarSampleEndContents() {
    IcDelete(
        contentDescription = null,
        modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(DodamDimen.AppBarDefaultIconSize)
    )
}
