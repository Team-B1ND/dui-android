package kr.hs.dgsw.smartschool.dui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.Item

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ColumnItemCard(item = DataSet.ITEM_TEST, navController = rememberNavController())
}

@Composable
fun ColumnItemCard(
    item: Item,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(110.dp)
            .width(320.dp)
            .padding(vertical = 10.dp)
            .clickable {
                navController.navigate(item.route)
            },
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
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
                    .padding(top = 10.dp, start = 10.dp)
                    .fillMaxHeight(),
                text = item.content,
                textAlign = TextAlign.Start,
                maxLines = 2
            )
        }
    }
}

@Composable
fun ItemImage(icon: Int) {
    Surface {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}
