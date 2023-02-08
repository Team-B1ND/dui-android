package kr.hs.dgsw.smartschool.components.component.set.navtab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.IcMeal
import kr.hs.dgsw.smartschool.components.theme.IcSong
import kr.hs.dgsw.smartschool.components.theme.IcUser
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

private val NavBarHeight = 56.dp

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = DodamTheme.color.White,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(NavBarHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

@Preview
@Composable
private fun NavBarPreview() {

    var selectedNavTab by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        NavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
        ) {
            NavTab(
                text = "홈",
                icon = { IcHome(contentDescription = null) },
                onClick = { selectedNavTab = 0 },
                selected = selectedNavTab == 0,
            )
            NavTab(
                text = "급식",
                icon = { IcMeal(contentDescription = null) },
                onClick = { selectedNavTab = 1 },
                selected = selectedNavTab == 1,
            )
            NavTab(
                text = "기상송",
                icon = { IcSong(contentDescription = null) },
                onClick = { selectedNavTab = 2 },
                selected = selectedNavTab == 2,
            )
            NavTab(
                text = "내 정보",
                icon = { IcUser(contentDescription = null) },
                onClick = { selectedNavTab = 3 },
                selected = selectedNavTab == 3,
            )
        }
    }
}
