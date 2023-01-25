package kr.hs.dgsw.smartschool.dui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.screen.Item

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    ColumnItemCard(item = DataSet.dummyCard)
}

@Composable
fun ColumnItemCard(item: Item) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .width(300.dp)
            .padding(vertical = 10.dp),
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        elevation = 3.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(20.dp)
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
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Start,

                    )
            }
            Body3(
                modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp)
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
    Surface{
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}