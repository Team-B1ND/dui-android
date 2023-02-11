package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamLargeRoundedButton
import kr.hs.dgsw.smartschool.components.component.organization.bottomsheet.BottomSheet
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.*
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_BOTTOM_SHEET, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .background(DodamColor.White)
                    .padding(10.dp)
            ) {
                Title2(text = "외부 박스")
                BottomSheet(
                    sheetContent = {
                        Column {
                            DodamItemCard(title = "Hello", subTitle = "test")
                            DodamItemCard(title = "Hello", subTitle = "test")
                            DodamItemCard(title = "Hello", subTitle = "test")
                        }
                    }
                ) {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(DodamColor.White)
                    ) {
                        Title2(text = "내부 박스")
                    }
                }
            }
        }
    }
}
