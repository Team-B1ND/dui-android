package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import kr.hs.dgsw.smartschool.components.component.button.Button
import kr.hs.dgsw.smartschool.components.component.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.component.tab.Tab
import kr.hs.dgsw.smartschool.components.component.tab.Tabs
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun TabPreview() {
    ButtonScreen(navController = rememberNavController())
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
        ScreenAppBar(title = "IconScreen", navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label Only")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                Tab(
                    text = "Tab1",
                    selected = selectedTab1.value == 1,
                    onClick = { selectedTab1.value = 1 },
                    modifier = Modifier.weight(1f),
                )
                Tab(
                    text = "Tab2",
                    selected = selectedTab1.value == 2,
                    onClick = { selectedTab1.value = 2 },
                    modifier = Modifier.weight(1f),
                )
                Tab(
                    text = "Tab3",
                    selected = selectedTab1.value == 3,
                    onClick = { selectedTab1.value = 3 },
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label O, Icon O")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                Tab(
                    text = "Tab1",
                    selected = selectedTab2.value == 1,
                    onClick = { selectedTab2.value = 1 },
                    icon = { IcHome(contentDescription = null)},
                    modifier = Modifier.weight(1f),
                )
                Tab(
                    text = "Tab2",
                    selected = selectedTab2.value == 2,
                    onClick = { selectedTab2.value = 2 },
                    icon = { IcHome(contentDescription = null)},
                    modifier = Modifier.weight(1f),
                )
                Tab(
                    text = "Tab3",
                    selected = selectedTab2.value == 3,
                    onClick = { selectedTab2.value = 3 },
                    icon = { IcHome(contentDescription = null)},
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Icon Only")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                Tab(
                    text = "Tab1",
                    selected = selectedTab3.value == 1,
                    onClick = { selectedTab3.value = 1 },
                    icon = { IcHome(contentDescription = null) },
                    showLabel = false,
                    modifier = Modifier.weight(1f),
                )
                Tab(
                    text = "Tab2",
                    selected = selectedTab3.value == 2,
                    onClick = { selectedTab3.value = 2 },
                    icon = { IcHome(contentDescription = null) },
                    showLabel = false,
                    modifier = Modifier.weight(1f),
                )
                Tab(
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