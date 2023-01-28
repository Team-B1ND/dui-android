package kr.hs.dgsw.smartschool.dui.screen
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.Item
import kr.hs.dgsw.smartschool.dui.Text
import kr.hs.dgsw.smartschool.dui.card.ColumnItemCard
import kr.hs.dgsw.smartschool.dui.compose.ScreenAppBar

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainScreen(viewModel = null, navController = rememberNavController())
    }
}

@Composable
fun MainScreen(
    viewModel: ViewModel?,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ColumnList(list = DataSet.LIST_MAIN, navController)
    }
}
@Composable
fun ColumnList(
    list: List<Item>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Title1(
            text = Text.DUI_TITLE,
            modifier = Modifier
                .padding(
                    start = 35.dp,
                    top = 40.dp,
                    bottom = 10.dp
                )
        )
        Title2(
            text = Text.DUI_DESCRIPTION,
            modifier = Modifier
                .padding(
                    start = 35.dp,
                    bottom = 20.dp
                )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(list) { item ->
                ColumnItemCard(
                    item = item,
                    navController = navController
                )
            }
        }
    }
}
