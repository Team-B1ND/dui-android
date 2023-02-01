package kr.hs.dgsw.smartschool.components.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.component.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcSong
import kr.hs.dgsw.smartschool.components.theme.Label1

@Composable
fun BottomSheet(
    sheetTopContent: @Composable ColumnScope.() -> Unit,
    sheetBottomContent: @Composable ColumnScope.() -> Unit,
    sheetElevation: Dp,
    modifier: Modifier = Modifier,
    sheetShape: Shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    content: @Composable () -> Unit,
) {

    BoxWithConstraints(modifier) {
        BottomSheetStack(body = {
            Column(modifier = Modifier.fillMaxSize()) {
                content()
            }
        }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = sheetElevation, shape = sheetShape, clip = false)
                    .clip(sheetShape)
            ) {
                Column(Modifier.background(DodamTheme.color.Background)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .width(26.dp)
                                .height(3.dp)
                                .background(
                                    color = DodamTheme.color.Gray200,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clip(RoundedCornerShape(20.dp))
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        sheetTopContent()
                    }
                    Divider(color = DodamTheme.color.Gray200)
                    sheetBottomContent()
                }
            }
        }
    }
}

@Composable
private fun BottomSheetStack(
    body: @Composable () -> Unit,
    bottomSheet: @Composable () -> Unit,
) {
    Layout(
        content = {
            body()
            bottomSheet()
        }
    ) { measurables, constraints ->
        val placeable = measurables.first().measure(constraints)

        layout(placeable.width, placeable.height) {
            placeable.placeRelative(0, 0)

            val (sheetPlaceable) = measurables.drop(1).map {
                it.measure(constraints.copy(minWidth = 0, minHeight = 0))
            }

            sheetPlaceable.placeRelative(0, constraints.maxHeight - sheetPlaceable.height)
        }
    }
}


@Preview
@Composable
private fun PreviewBottomSheet() {
    BottomSheet(
        sheetTopContent = { Label1(text = "Title", modifier = Modifier.align(Alignment.CenterHorizontally)) },
        sheetBottomContent = { DodamItemCard(title = "test", subTitle = "TestTest") },
        sheetShape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
        sheetElevation = 16.dp,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(DodamTheme.color.MainColor400)
        ) {
            IcSong(contentDescription = null)
        }
    }
}