package kr.hs.dgsw.smartschool.components.component.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.IcSearch
import kr.hs.dgsw.smartschool.components.theme.IcSong
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

@Composable
fun Tabs(
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
                .selectableGroup()
                .wrapContentWidth(Alignment.CenterHorizontally),
            content = content,
        )
    }
}

@Preview
@Composable
private fun TabsPreview() {
    Column {
        var selectedTab1 by remember { mutableStateOf(1) }
        Tabs(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Tab(
                text = "ITEM ONE",
                selected = selectedTab1 == 1,
                onClick = { selectedTab1 = 1 },
                modifier = Modifier.weight(1f),
            )
            Tab(
                text = "ITEM TWO",
                selected = selectedTab1 == 2,
                onClick = { selectedTab1 = 2 },
                modifier = Modifier.weight(1f),
            )
            Tab(
                text = "ITEM THREE",
                selected = selectedTab1 == 3,
                onClick = { selectedTab1 = 3 },
                modifier = Modifier
                    .weight(1f),
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        var selectedTab2 by remember { mutableStateOf(1) }
        Tabs(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Tab(
                text = "ITEM ONE",
                selected = selectedTab2 == 1,
                onClick = { selectedTab2 = 1 },
                modifier = Modifier.weight(1f),
                icon = { IcHome(contentDescription = null) },
            )
            Tab(
                text = "ITEM TWO",
                selected = selectedTab2 == 2,
                onClick = { selectedTab2 = 2 },
                modifier = Modifier.weight(1f),
                icon = { IcSong(contentDescription = null) },
            )
            Tab(
                text = "ITEM THREE",
                selected = selectedTab2 == 3,
                onClick = { selectedTab2 = 3 },
                modifier = Modifier
                    .weight(1f),
                icon = { IcSearch(contentDescription = null) },
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        var selectedTab3 by remember { mutableStateOf(1) }
        Tabs(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Tab(
                text = "ITEM ONE",
                selected = selectedTab3 == 1,
                onClick = { selectedTab3 = 1 },
                modifier = Modifier.weight(1f),
                icon = { IcHome(contentDescription = null) },
                showLabel = false,
            )
            Tab(
                text = "ITEM TWO",
                selected = selectedTab3 == 2,
                onClick = { selectedTab3 = 2 },
                modifier = Modifier.weight(1f),
                icon = { IcSong(contentDescription = null) },
                showLabel = false,
            )
            Tab(
                text = "ITEM THREE",
                selected = selectedTab3 == 3,
                onClick = { selectedTab3 = 3 },
                modifier = Modifier
                    .weight(1f),
                icon = { IcSearch(contentDescription = null) },
                showLabel = false,
            )
        }
    }
}
