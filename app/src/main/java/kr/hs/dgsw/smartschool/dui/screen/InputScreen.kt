package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.input.DodamInput
import kr.hs.dgsw.smartschool.components.component.basic.input.area.DodamInputArea
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcSearch
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun InputPreview() {
    InputScreen(navController = rememberNavController())
}

@Composable
fun InputScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(
            title = DataSet.Text.TITLE_INPUT,
            onStartIconClick = { navController.popBackStack() },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = DodamDimen.ScreenSidePadding)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            SampleInputArea(
                modifier = Modifier
                    .fillMaxSize(),
                focusColor = DodamColor.MainColor,
                icon = { IcSearch(contentDescription = null) }
            )
            Spacer(modifier = Modifier.height(20.dp))
            SampleInputArea()
        }
    }
}

@Composable
fun SampleInputArea(
    modifier: Modifier,
    hint: String = DataSet.Text.TEXT_HINT,
    focusColor: Color,
    icon: (@Composable () -> Unit)
) {
    val text = remember {
        mutableStateOf("")
    }
    Spacer(modifier = Modifier.height(20.dp))
    Title2(text = "Dodam Input")
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

@Composable
fun SampleInputArea() {
    Spacer(modifier = Modifier.height(20.dp))
    Title2(text = "Dodam Input Area")
    Spacer(modifier = Modifier.height(20.dp))
    Column() {
        var testValue by remember { mutableStateOf("") }
        DodamInputArea(
            value = testValue,
            onValueChange = { testValue = it },
            hint = "Hello World",
        )

        Spacer(modifier = Modifier.height(10.dp))

        var testValue2 by remember { mutableStateOf("") }
        DodamInputArea(
            value = testValue2,
            onValueChange = { testValue2 = it },
            topLabel = "Top Label",
            hint = "Input Some Text"
        )

        Spacer(modifier = Modifier.height(10.dp))

        var testValue3 by remember { mutableStateOf("") }
        DodamInputArea(
            value = testValue3,
            onValueChange = { testValue3 = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
            topLabel = "Top Label",
            bottomLabel = "Bottom Label",
            hint = "사이즈 조정 가능",
            isError = testValue3 == "Hello",
            focusColor = DodamColor.FeatureColor.ItMapColor,
        )
    }
}
