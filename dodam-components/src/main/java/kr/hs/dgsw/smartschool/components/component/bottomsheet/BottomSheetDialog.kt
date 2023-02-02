package kr.hs.dgsw.smartschool.components.component.bottomsheet

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.component.card.DodamItemCard
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Label1

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDialog(
    sheetTopContent: @Composable ColumnScope.() -> Unit,
    sheetBottomContent: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    sheetElevation: Dp = 0.dp,
    sheetShape: Shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    sheetBackgroundColor: Color = DodamTheme.color.Background,
    sheetPickHeight: Dp = 70.dp,
    content: @Composable (sheetState: BottomSheetState) -> Unit,
) {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                BottomSheetBar()
                sheetTopContent()
            }
            Divider(color = DodamTheme.color.Gray200)
            sheetBottomContent()
        },
        sheetPeekHeight = sheetPickHeight,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetShape = sheetShape,
        sheetElevation = sheetElevation,
    ) {
        content(sheetState)
    }
}

@Composable
fun ColumnScope.BottomSheetBar() {
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
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun PreviewBottomSheetDialog() {
    val context = LocalContext.current
    BottomSheetDialog(
        sheetTopContent = {
            Spacer(modifier = Modifier.height(18.dp))
            Label1(
                text = "Title",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        },
        sheetBottomContent = {
            DodamItemCard(title = "TestTitle", subTitle = "title")
        },
    ) { sheetState ->
        Display1(text = "Test", onClick = {
            Toast.makeText(context, sheetState.isExpanded.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}
