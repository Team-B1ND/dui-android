package kr.hs.dgsw.smartschool.dui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.R
import kr.hs.dgsw.smartschool.dui.root.ItemImage

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
        DodamAppBar(title = DataSet.Text.TITLE_COLOR, onStartIconClick = { navController.popBackStack() })

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
            Palette(
                title = "SecondaryColor",
                color0 = DodamColor.SecondaryColor50,
                color1 = DodamColor.SecondaryColor100,
                color2 = DodamColor.SecondaryColor200,
                color3 = DodamColor.SecondaryColor300,
                color4 = DodamColor.SecondaryColor400,
                color5 = DodamColor.SecondaryColor500,
                color6 = DodamColor.SecondaryColor600,
                color7 = DodamColor.SecondaryColor700,
                color8 = DodamColor.SecondaryColor800,
                color9 = DodamColor.SecondaryColor900,
            )
            Palette(
                title = "Gray",
                color0 = DodamColor.Gray50,
                color1 = DodamColor.Gray100,
                color2 = DodamColor.Gray200,
                color3 = DodamColor.Gray300,
                color4 = DodamColor.Gray400,
                color5 = DodamColor.Gray500,
                color6 = DodamColor.Gray600,
                color7 = DodamColor.Gray700,
                color8 = DodamColor.Gray800,
                color9 = DodamColor.Gray900,
            )
            Palette(
                title = "Feature",
                color0 = DodamColor.FeatureColor.SongColor,
                color1 = DodamColor.FeatureColor.ItMapColor,
                color2 = DodamColor.FeatureColor.LostFoundColor,
                color3 = DodamColor.FeatureColor.MyInfoColor,
                color4 = DodamColor.FeatureColor.ScheduleColor
            )

            Palette(
                title = "Check & Error",
                color0 = DodamColor.Check,
                color1 = DodamColor.Error
            )
            Palette(
                title = "Background",
                color0 = DodamColor.White,
                color1 = DodamColor.Black,
                color2 = DodamColor.Background
            )
        }
    }
}

@Composable
fun Palette(
    title: String,
    color0: Color = DodamColor.White,
    color1: Color = DodamColor.White,
    color2: Color = DodamColor.White,
    color3: Color = DodamColor.White,
    color4: Color = DodamColor.White,
    color5: Color = DodamColor.White,
    color6: Color = DodamColor.White,
    color7: Color = DodamColor.White,
    color8: Color = DodamColor.White,
    color9: Color = DodamColor.White,
) {
    val colorCode = remember { mutableStateOf(Integer.toHexString(color0.hashCode())) }
    Spacer(
        modifier = Modifier
            .padding(top = 30.dp)
    )
    Title2(
        text = title,
        textColor = DodamColor.Black
    )
    Row(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
    ) {
        PalettePart(color0, colorCode, "50")
        PalettePart(color1, colorCode, "100")
        PalettePart(color2, colorCode, "200")
        PalettePart(color3, colorCode, "300")
        PalettePart(color4, colorCode, "400")
        PalettePart(color5, colorCode, "500")
        PalettePart(color6, colorCode, "600")
        PalettePart(color7, colorCode, "700")
        PalettePart(color8, colorCode, "800")
        PalettePart(color9, colorCode, "900")
    }
    Spacer(
        modifier = Modifier
            .padding(top = 3.dp)
    )
    Body2(text = "선택된 색은 ${colorCode.value.uppercase()}", textColor = DodamColor.Black)
}

@Composable
fun PalettePart(
    color: Color,
    colorCode: MutableState<String>,
    value: String
) {
    Column(
        modifier = Modifier
            .height(110.dp)
            .width(30.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color)
                .height(90.dp)
                .width(30.dp)
                .clickable {
                    colorCode.value = Integer.toHexString(color.hashCode())
                },
            contentAlignment = Alignment.Center
        ) {
            if (Integer.toHexString(color.hashCode()) == colorCode.value) {
                ItemImage(icon = R.drawable.ic_palette_flat)
            }
        }
        Label3(
            text = value,
            modifier = Modifier
                .width(30.dp),
            textColor = DodamColor.Gray700
        )
    }
}
