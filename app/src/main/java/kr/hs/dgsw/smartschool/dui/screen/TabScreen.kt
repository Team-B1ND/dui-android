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
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.component.tab.Tab
import kr.hs.dgsw.smartschool.components.component.tab.Tabs
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
    val itemCount = remember {
        mutableStateOf(2)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        ScreenAppBar(title = "IconScreen", navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Input(
                value = itemCount.value.toString(),
                onValueChange = {itemCount.value = it.toInt()},
                hint = "count"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label Only")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                for(i : Int in 2..itemCount.value){
                    Tab(
                        text = "TEST",
                        selected = selectedTab1.value == i,
                        onClick = { selectedTab1.value = i }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Label O, Icon O")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                for(i : Int in 2..itemCount.value){
                    Tab(
                        text = "TEST",
                        selected = selectedTab1.value == i,
                        onClick = { selectedTab1.value = i },
                        icon = { IcHome(contentDescription = null) },
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Icon Only")
            Spacer(modifier = Modifier.height(20.dp))
            Tabs() {
                for(i : Int in 2..itemCount.value){
                    Tab(
                        text = "TEST",
                        selected = selectedTab1.value == i,
                        onClick = { selectedTab1.value = i },
                        icon = { IcHome(contentDescription = null) },
                        showLabel = false
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}