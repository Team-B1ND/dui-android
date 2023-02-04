package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.button.*
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcOut3D
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun ButtonPreview() {
    ButtonScreen(navController = rememberNavController())
}

@Composable
fun ButtonScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        ScreenAppBar(title = "IconScreen", navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonRow(title = "Primary", type = ButtonType.Primary)
            ButtonRow(title = "Primary Variant", type = ButtonType.PrimaryVariant)
            ButtonRow(title = "Secondary", type = ButtonType.Secondary)
            ButtonRow(title = "Secondary Variant", type = ButtonType.SecondaryVariant)
            ButtonRow(title = "LostFound", type = ButtonType.LostFound)
            ButtonRow(title = "Itmap", type = ButtonType.Itmap)
            ButtonRow(title = "MyInfo", type = ButtonType.MyInfo)
            ButtonRow(title = "Schedule", type = ButtonType.Schedule)
            ButtonRow(title = "Song", type = ButtonType.Song)
            ButtonRow(title = "Danger", type = ButtonType.Danger)
            ButtonRow(title = "Disable", type = ButtonType.Disable)
        }
    }
}

@Composable
fun ButtonRow(
    title: String,
    type: ButtonType,
    onClick: () -> Unit = {}
) {
    var selected : MutableState<Boolean> = remember {
        mutableStateOf(true)
    }
    Spacer(modifier = Modifier.height(30.dp))
    Title2(text = title)
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(icon = { IcOut3D(contentDescription = null) }, onClick = { onClick() }, type = type)
        Spacer(modifier = Modifier.width(7.dp))
        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value}, type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamSmallRoundedButton(onClick = { onClick() }, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamMediumRoundedButton(onClick = { onClick() }, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamLargeRoundedButton(onClick = { onClick() }, text = "Button", type = type)
    }
}
