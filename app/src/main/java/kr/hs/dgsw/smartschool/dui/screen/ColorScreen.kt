package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun ColorPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ColorScreen(navController = rememberNavController())
    }
}

@Composable
fun ColorScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenAppBar(title = "ColorScreen", navController = navController)

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Palette(
                title = "MainColor",
                color0 = DodamColor.MainColor50,
                color1 = DodamColor.MainColor100,
                color2 = DodamColor.MainColor200,
                color3 = DodamColor.MainColor300,
                color4 = DodamColor.MainColor400,
                color5 = DodamColor.MainColor500,
                color6 = DodamColor.MainColor600,
                color7 = DodamColor.MainColor700,
                color8 = DodamColor.MainColor800,
                color9 = DodamColor.MainColor900
            )
        }
    }
}

@Composable
fun Palette(
    title : String,
    color0 : Color,
    color1 : Color,
    color2 : Color,
    color3 : Color,
    color4 : Color,
    color5 : Color,
    color6 : Color,
    color7 : Color,
    color8 : Color,
    color9 : Color
){
    Spacer(
        modifier = Modifier
            .padding(top = 30.dp)
    )
    Title1(
        text = title,
        textColor = DodamColor.Black
    )
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ){
        PalettePart(color0)
        PalettePart(color1)
        PalettePart(color2)
        PalettePart(color3)
        PalettePart(color4)
        PalettePart(color5)
        PalettePart(color6)
        PalettePart(color7)
        PalettePart(color8)
        PalettePart(color9)
    }
}

@Composable
fun PalettePart(
    color : Color
){
    Box(
        modifier = Modifier
            .background(color)
            .fillMaxHeight()
            .width(30.dp)
    )
}
