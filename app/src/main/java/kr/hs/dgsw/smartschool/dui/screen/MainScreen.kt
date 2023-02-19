package kr.hs.dgsw.smartschool.dui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.organization.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.root.ItemImage

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainScreen(navController = rememberNavController())
    }
}

@Composable
fun MainScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = DodamColor.Background
    ) {
        ColumnList(list = DataSet.LIST_MAIN, navController)
    }
}
@Composable
fun ColumnList(
    list: List<DataSet.Item>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = DodamDimen.ScreenSidePadding)
            .background(DodamColor.Background)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Title1(
            text = DataSet.Text.TITLE_DUI,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(10.dp))
        Title2(
            text = DataSet.Text.DESCRIPTION_DUI,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(list) { item ->
                DodamItemCard(
                    title = item.title,
                    subTitle = item.content,
                    modifier = Modifier
                        .width(320.dp),
                    onClick = { navController.navigate(item.route) },
                    icon = { ItemImage(item.icon) }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
