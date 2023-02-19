package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.organization.bottomsheet.DodamBottomSheet
import kr.hs.dgsw.smartschool.components.component.organization.bottomsheet.DodamBottomSheetDialog
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.component.set.tab.DodamTab
import kr.hs.dgsw.smartschool.components.component.set.tab.DodamTabs
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun BottomSheetPreview() {
    BottomSheetScreen(navController = rememberNavController())
}
@Composable
fun BottomSheetScreen(
    navController: NavController
) {
    val bottomSheetNavController = rememberNavController()
    val tabSelected = remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(
            title = DataSet.Text.TITLE_BOTTOM_SHEET,
            onStartIconClick = { navController.popBackStack() }
        )
        DodamTabs(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DodamTab(
                modifier = Modifier
                    .weight(1f),
                text = "BottomSheet",
                selected = tabSelected.value == 1,
                onClick = {
                    tabSelected.value = 1
                    bottomSheetNavController.navigate("bottom_sheet")
                }
            )
            DodamTab(
                modifier = Modifier
                    .weight(1f),
                text = "BottomSheet " +
                        "Dialog",
                selected = tabSelected.value == 2,
                onClick = {
                    tabSelected.value = 2
                    bottomSheetNavController.navigate("bottom_sheet_dialog")
                }
            )
        }
        NavHost(
            navController = bottomSheetNavController,
            startDestination = "bottom_sheet",
            modifier = Modifier
        ) {
            composable("bottom_sheet") {
                BottomSheetPlayGround()
            }
            composable("bottom_sheet_dialog") {
                BottomSheetDialogPlayground()
            }
        }
    }
}

@Composable
fun BottomSheetPlayGround() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = DodamDimen.ScreenSidePadding)
            .background(DodamColor.Background),
        horizontalAlignment = Alignment.CenterHorizontally,
    )  {
        Spacer(modifier = Modifier.height(20.dp))
        Title2(text = "BottomSheet")
        Spacer(modifier = Modifier.height(10.dp))
        DodamBottomSheet(
            modifier = Modifier
                .background(DodamColor.White),
            sheetContent = {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            content = {
                Display1(text = "Content")
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDialogPlayground() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = DodamDimen.ScreenSidePadding)
            .background(DodamColor.Background),
        horizontalAlignment = Alignment.CenterHorizontally,
    )  {
        Spacer(modifier = Modifier.height(20.dp))
        Title2(text = "BottomSheet Dialog")
        Spacer(modifier = Modifier.height(10.dp))
        DodamBottomSheetDialog(
            modifier = Modifier
                .background(DodamColor.White),
            sheetTopContent = {
                Spacer(modifier = Modifier.height(18.dp))
                Label1(
                    text = "SheetContent",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            },
            sheetBottomContent = {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                    DodamItemCard(
                        title = "SheetContent",
                        subTitle = "DodamItemCard",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
        ) {
            Display1(text = "Content")
        }
    }
}
