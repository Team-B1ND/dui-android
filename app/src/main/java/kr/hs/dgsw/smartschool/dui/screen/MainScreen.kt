package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title3


@Preview(showBackground = true)
@Composable
fun TestPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        MainScreen(viewModel = null)
    }
}

data class Item(
    val icon : Int,
    val title : String,
    val content : String
)


@Composable
fun MainScreen(viewModel : ViewModel?){
    val list : List<Item> = listOf(
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용"),
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용"),
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용")
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ListScreen(list = list)
    }
}
@Composable
fun ListScreen(
    list : List<Item>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Title1(
            text = "DUI",
            modifier = Modifier
                .padding(start = 30.dp, bottom = 50.dp)
        )
        ColumnList(list = list)
    }
}

@Composable
fun ColumnList(list : List<Item>){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        items(list) { item ->
            ColumnItemCard(
                item = item
            )
        }
    }
}

@Composable
fun ColumnItemCard(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        elevation = 3.dp
    ) {
        Column(modifier = Modifier
            .height(100.dp)
            .width(300.dp)
            .padding(all = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) {
                ItemImage(
                    item.icon
                )
                Title3(
                    text = item.title
                )
            }
            Body3(text = "내용")
        }
    }
}

@Composable
fun ItemImage(icon : Int){
    Surface(shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp))) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}