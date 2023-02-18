package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.button.ButtonType
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamIconButton
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamLargeRoundedButton
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamRadioButton
import kr.hs.dgsw.smartschool.components.component.basic.button.DodamSmallRoundedButton
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcAdd
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet

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
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_BUTTON, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
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
    val selected: MutableState<Boolean> = remember {
        mutableStateOf(true)
    }
    Spacer(modifier = Modifier.height(30.dp))
    Title2(text = title)
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Label3(text = "Icon\nButton", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.width(25.dp))
        Label3(text = "Radio\nButton", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.width(25.dp))
        Label3(text = "Small\nRounded", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.width(25.dp))
        Label3(text = "Medium\nRounded", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.width(25.dp))
        Label3(text = "Large\nRounded", textAlign = TextAlign.Center)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DodamIconButton(icon = { IcAdd(contentDescription = null) }, onClick = { onClick() }, type = type)
        Spacer(modifier = Modifier.width(20.dp))
        DodamRadioButton(selected = selected.value, onClick = { selected.value = !selected.value }, type = type)
        Spacer(modifier = Modifier.width(20.dp))
        DodamSmallRoundedButton(onClick = { onClick() }, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamMediumRoundedButton(onClick = { onClick() }, text = "Button", type = type)
        Spacer(modifier = Modifier.width(7.dp))
        DodamLargeRoundedButton(onClick = { onClick() }, text = "Button", type = type)
    }
}
