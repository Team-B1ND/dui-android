package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.button.*
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
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
            ButtonRow(title = "Primary Button", type = ButtonType.Primary)
            ButtonRow(title = "Primary Button", type = ButtonType.PrimaryVariant)
            ButtonRow(title = "Primary Button", type = ButtonType.Secondary)
            ButtonRow(title = "Primary Button", type = ButtonType.SecondaryVariant)
            ButtonRow(title = "Primary Button", type = ButtonType.LostFound)
            ButtonRow(title = "Primary Button", type = ButtonType.Itmap)
            ButtonRow(title = "Primary Button", type = ButtonType.MyInfo)
            ButtonRow(title = "Primary Button", type = ButtonType.Schedule)
            ButtonRow(title = "Primary Button", type = ButtonType.Song)
            ButtonRow(title = "Primary Button", type = ButtonType.Danger)
            ButtonRow(title = "Primary Button", type = ButtonType.Disable)
        }
    }
}

@Composable
fun ButtonRow(
    title : String,
    type: ButtonType,
    onClick : @Composable (()-> Unit) = {}
){
    Spacer(modifier = Modifier.height(30.dp))
    Title2(text = title)
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically){
        IconButton(icon = { IcOut3D(contentDescription = null) }, onClick = { /*TODO*/ }, type = type)
        Spacer(modifier = Modifier.width(7.dp))
        RadioButton(selected = true, onClick = { /*TODO*/ }, type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamSmallRoundedButton(onClick = {}, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamMediumRoundedButton(onClick = {}, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamLargeRoundedButton(onClick = {}, text = "Button", type = type)
    }
}

