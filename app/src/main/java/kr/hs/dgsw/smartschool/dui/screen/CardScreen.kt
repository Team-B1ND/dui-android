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
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamContentCard
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun CardPreview() {
    CardScreen(navController = rememberNavController())
}

@Composable
fun CardScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_CARD, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Item Card")
            Spacer(modifier = Modifier.height(10.dp))

            DodamItemCard(
                title = "도담 Item Card",
                subTitle = "subTitle",
            )
            DodamItemCard(
                title = "도담 Item Card",
                subTitle = "subTitle",
                icon = { IcOut3D(contentDescription = null) }
            )
            DodamItemCard(
                title = "도담 Item Card",
                subTitle = "subTitle",
                icon = { IcOut3D(contentDescription = null) },
                modifier = Modifier
                    .width(320.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Content Card")
            Spacer(modifier = Modifier.height(10.dp))

            DodamContentCard(
                title = "도담 Item Card",
            )
            Spacer(modifier = Modifier.height(10.dp))
            DodamContentCard(
                title = "오늘의 석식", hasLinkIcon = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            DodamContentCard(
                title = "도담 Item Card",
                hasLinkIcon = true
            ){
                Row(modifier = Modifier.fillMaxWidth()) {
                    IcDinner3D(contentDescription = null, modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Body3(text = "오늘은 급식이 없네요!", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
        }
    }
}
