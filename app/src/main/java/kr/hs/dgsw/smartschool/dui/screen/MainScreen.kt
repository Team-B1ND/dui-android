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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
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
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용..................................................................sddddddddadwㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷ")
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
            text = "DUI Preview",
            modifier = Modifier
                .padding(
                    start = 35.dp,
                    top = 40.dp,
                    bottom = 10.dp
                    )
        )
        Title2(
            text = "도담 디자인 시스템",
            modifier = Modifier
                .padding(
                    start = 35.dp,
                    bottom = 20.dp
                )
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
                    .height(30.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                ItemImage(
                    item.icon
                )
                Title2(
                    text = item.title,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 20.dp),
                    textAlign = TextAlign.Start
                )
            }
            Body3(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxHeight(),
                text = item.content,
                textAlign = TextAlign.Start,
                maxLines = 2
            )
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