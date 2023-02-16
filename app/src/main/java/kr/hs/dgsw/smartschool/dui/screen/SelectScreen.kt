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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.input.DodamInput
import kr.hs.dgsw.smartschool.components.component.basic.input.DodamSelect
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun SelectPreview() {
    SelectScreen(navController = rememberNavController())
}

@Composable
fun SelectScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_SELECT, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Select")
            Spacer(modifier = Modifier.height(10.dp))
            SampleSelect(modifier = Modifier, focusColor = DodamColor.MainColor) {
                
            }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Select Area")
            Spacer(modifier = Modifier.height(10.dp))
            SampleSelectArea(modifier = Modifier, focusColor = DodamColor.MainColor) {

            }
        }
    }
}

@Composable
fun SampleSelect(
    modifier: Modifier,
    hint: String = DataSet.Text.TEXT_HINT,
    focusColor: Color,
    icon: (@Composable () -> Unit)
) {
    val text = remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            trailingIcon = icon,
            modifier = Modifier.fillMaxWidth()
        )
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SampleSelectArea(
    modifier: Modifier,
    hint: String = DataSet.Text.TEXT_HINT,
    focusColor: Color,
    icon: (@Composable () -> Unit)
) {
    val text = remember {
        mutableStateOf("")
    }
    Spacer(modifier = Modifier.height(20.dp))
    Title2(text = "Input")
    Spacer(modifier = Modifier.height(20.dp))
    Column(modifier = modifier) {
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            trailingIcon = icon,
            modifier = Modifier.fillMaxWidth()
        )
        DodamInput(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
