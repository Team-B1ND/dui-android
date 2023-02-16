package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.component.set.tab.DodamTab
import kr.hs.dgsw.smartschool.components.component.set.tab.DodamTabs
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun TabPreview() {
    TabScreen(navController = rememberNavController())
}

@Composable
fun TabScreen(
    navController: NavController
) {
    val selectedTab1 = remember {
        mutableStateOf(1)
    }
    val selectedTab2 = remember {
        mutableStateOf(1)
    }
    val selectedTab3 = remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(onStartIconClick = { navController.popBackStack() }, title = DataSet.Text.TITLE_TAB)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label Only")
            Spacer(modifier = Modifier.height(20.dp))
            DodamTabs {
                DodamTab(
                    text = "Tab1",
                    selected = selectedTab1.value == 1,
                    onClick = { selectedTab1.value = 1 },
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab2",
                    selected = selectedTab1.value == 2,
                    onClick = { selectedTab1.value = 2 },
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab3",
                    selected = selectedTab1.value == 3,
                    onClick = { selectedTab1.value = 3 },
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label O, Icon O")
            Spacer(modifier = Modifier.height(20.dp))
            DodamTabs {
                DodamTab(
                    text = "Tab1",
                    selected = selectedTab2.value == 1,
                    onClick = { selectedTab2.value = 1 },
                    icon = { IcHome(contentDescription = null) },
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab2",
                    selected = selectedTab2.value == 2,
                    onClick = { selectedTab2.value = 2 },
                    icon = { IcHome(contentDescription = null) },
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab3",
                    selected = selectedTab2.value == 3,
                    onClick = { selectedTab2.value = 3 },
                    icon = { IcHome(contentDescription = null) },
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Icon Only")
            Spacer(modifier = Modifier.height(20.dp))
            DodamTabs() {
                DodamTab(
                    text = "Tab1",
                    selected = selectedTab3.value == 1,
                    onClick = { selectedTab3.value = 1 },
                    icon = { IcHome(contentDescription = null) },
                    showLabel = false,
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab2",
                    selected = selectedTab3.value == 2,
                    onClick = { selectedTab3.value = 2 },
                    icon = { IcHome(contentDescription = null) },
                    showLabel = false,
                    modifier = Modifier.weight(1f),
                )
                DodamTab(
                    text = "Tab3",
                    selected = selectedTab3.value == 3,
                    onClick = { selectedTab3.value = 3 },
                    icon = { IcHome(contentDescription = null) },
                    showLabel = false,
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
