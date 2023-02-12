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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.organization.bottomsheet.BottomSheet
import kr.hs.dgsw.smartschool.components.component.organization.bottomsheet.BottomSheetDialog
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun BottomSheetPreview() {
    BottomSheetScreen(navController = rememberNavController())
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(
            title = DataSet.Text.TITLE_BOTTOM_SHEET,
            onStartIconClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "BottomSheet")
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .background(DodamColor.White)
                    .padding(10.dp)
            ) {
                BottomSheet(
                    modifier = Modifier
                        .padding(10.dp),
                    sheetContent = {
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                    },
                    content = {
                        Display1(text = "Content")
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "BottomSheet Dialog")
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .background(DodamColor.White)
                    .padding(10.dp)
            ) {
                BottomSheetDialog(
                    modifier = Modifier
                        .padding(10.dp),
                    sheetTopContent = {
                        Spacer(modifier = Modifier.height(18.dp))
                        Label1(
                            text = "SheetContent",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    },
                    sheetBottomContent = {
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                        DodamItemCard(title = "SheetContent", subTitle = "DodamItemCard", modifier = Modifier.fillMaxWidth())
                    },
                ) {
                    Display1(text = "Content", onClick = {
                    })
                }
            }
        }
    }
}
