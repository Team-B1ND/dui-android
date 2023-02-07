package kr.hs.dgsw.smartschool.dui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamShape
import kr.hs.dgsw.smartschool.components.theme.Title2

@Composable
@Preview(showBackground = true)
fun ShapePreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ShapeScreen(navController = rememberNavController())
    }
}

@Composable
fun ShapeScreen(
    navController: NavController
) {
    val dodamShape = DodamShape()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DodamAppBar(title = "Shape", onStartIconClick = { navController.popBackStack() })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Title2(text = "도담 Shape")
            Spacer(modifier = Modifier.height(10.dp))
            ShapeBox(dodamShape.small, "DodamShape.small", "5.dp")
            ShapeBox(dodamShape.medium, "DodamShape.medium", "10.dp")
            ShapeBox(dodamShape.large, "DodamShape.large", "20.dp")
        }
    }
}

@Composable
fun ShapeBox(
    shape: CornerBasedShape,
    name: String,
    cornerShape: String
) {
    Box(
        modifier = Modifier
            .background(DodamColor.White)
            .fillMaxWidth()
            .height(100.dp)
            .border(
                width = 2.dp,
                color = DodamColor.MainColor,
                shape = shape
            )
            .padding(20.dp),

    ) {
        Column {
            Body3(text = "size = $name")
            Body3(text = "cornerShape = $cornerShape")
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
