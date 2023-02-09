package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.button.*
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamContentCard
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.component.organization.card.MealCard
import kr.hs.dgsw.smartschool.components.component.organization.card.MealType
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
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_CARD, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Item Card")
            Spacer(modifier = Modifier.height(10.dp))

            DodamItemCard(
                title = "Item Card",
                subTitle = "subTitle",
            )
            Spacer(modifier = Modifier.height(10.dp))
            DodamItemCard(
                title = "Item Card",
                subTitle = "subTitle",
                icon = { IcOut3D(contentDescription = null) }
            )
            Spacer(modifier = Modifier.height(10.dp))
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
                title = "Content Card",
            )
            Spacer(modifier = Modifier.height(10.dp))
            DodamContentCard(
                title = "Content Card", hasLinkIcon = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            DodamContentCard(
                title = "Content Card",
                hasLinkIcon = true
            ){
                Row(modifier = Modifier.fillMaxWidth()) {
                    IcDinner3D(contentDescription = null, modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Body3(text = "오늘은 급식이 없네요!", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            DodamContentCard(
                title = "Content Card",
                hasLinkIcon = true
            ){
                val selected: MutableState<Boolean> = remember {
                    mutableStateOf(true)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(icon = { IcAdd(contentDescription = null) }, onClick = { })
                    Spacer(modifier = Modifier.width(20.dp))
                    RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
                    Spacer(modifier = Modifier.width(20.dp))
                    DodamSmallRoundedButton(onClick = { }, text = "Button")
                    Spacer(modifier = Modifier.width(7.dp))
                    DodamMediumRoundedButton(onClick = { }, text = "Button")
                    Spacer(modifier = Modifier.width(7.dp))
                    DodamLargeRoundedButton(onClick = { }, text = "Button")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Content Card")
            Spacer(modifier = Modifier.height(10.dp))
            
            MealCard(content = DataSet.Text.TEXT_MEAL, mealType = MealType.BreakFast)
            Spacer(modifier = Modifier.height(10.dp))
            MealCard(content = DataSet.Text.TEXT_MEAL, mealType = MealType.Dinner)
            Spacer(modifier = Modifier.height(10.dp))
            MealCard(content = DataSet.Text.TEXT_MEAL, mealType = MealType.Lunch)
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}
