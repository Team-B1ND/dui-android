package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.toggle.DodamCheckBox
import kr.hs.dgsw.smartschool.components.component.basic.toggle.DodamSelectSwitch
import kr.hs.dgsw.smartschool.components.component.basic.toggle.DodamSwitch
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun TogglePreview() {
    ToggleScreen(navController = rememberNavController())
}

@Composable
fun ToggleScreen(
    navController: NavController
) {
    val checkColor1 = remember {
        mutableStateOf(DodamColor.Error)
    }
    val checkColor2 = remember {
        mutableStateOf(DodamColor.Error)
    }
    val checkColor3 = remember {
        mutableStateOf(DodamColor.Check)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_TOGGLE, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(DodamDimen.ScreenSidePadding)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Check Box")
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    DodamCheckBox(){isChecked ->
                        if(isChecked) checkColor1.value = DodamColor.Check
                        else checkColor1.value = DodamColor.Error
                    }
                    Label3(text = "Check Box")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(checkColor1.value)
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Title2(text = "Switch")
            Spacer(modifier = Modifier.height(10.dp))
            Column{
                Row {
                    Column {
                        DodamSwitch { isChecked ->
                            if(isChecked) checkColor2.value = DodamColor.Check
                            else checkColor2.value = DodamColor.Error
                        }
                        Label3(text = "Switch")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(checkColor2.value)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Column {
                        DodamSelectSwitch { isChecked ->
                            if(isChecked) checkColor3.value = DodamColor.Check
                            else checkColor3.value = DodamColor.Error
                        }
                        Label3(text = "Select Switch")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(checkColor3.value)
                        )
                    }
                }
            }
        }
    }
}
