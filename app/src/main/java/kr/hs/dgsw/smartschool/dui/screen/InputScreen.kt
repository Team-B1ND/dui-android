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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcSearch
import kr.hs.dgsw.smartschool.components.theme.Title2
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
            .background(DodamColor.White)
    ) {
        DodamAppBar(
            title = "Input",
            onStartIconClick = { navController.popBackStack() },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TestInputArea(
                modifier = Modifier
                    .fillMaxSize(),
                focusColor = DodamColor.MainColor,
                icon = { IcSearch(contentDescription = null) }
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun TestInputArea(
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
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            trailingIcon = icon,
            modifier = Modifier.fillMaxWidth()
        )
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            leadingIcon = icon,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
