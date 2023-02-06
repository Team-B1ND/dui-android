package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.component.input.InputDecoration
import kr.hs.dgsw.smartschool.components.component.input.InputType
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcSearch
import kr.hs.dgsw.smartschool.dui.DataSet
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

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
        ScreenAppBar(title = "IconScreen", navController = navController)
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
                    .fillMaxSize()
                ,
                focusColor = DodamColor.MainColor,
                icon = { IcSearch(contentDescription = null) }
            )

            TestInputDecorationArea(
                modifier = Modifier,
                inputType = InputType.Default,
                focusColor = DodamColor.MainColor
            ){}

            TestInputDecorationArea(
                modifier = Modifier,
                inputType = InputType.Error.Default,
                focusColor = DodamColor.MainColor
            ){}
        }
    }
}

@Composable
fun TestInputArea(
    modifier: Modifier,
    hint : String = DataSet.Text.TEXT_HINT,
    focusColor : Color,
    icon : (@Composable () -> Unit)
){
    val text = remember {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor
        )
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            trailingIcon = icon
        )
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = hint,
            focusColor = focusColor,
            leadingIcon = icon
        )
        Input(
            value = text.value,
            onValueChange = { text.value = it },
            hint = "modifier을 통해 사이즈 조절 가능",
            focusColor = focusColor,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun TestInputDecorationArea(
    modifier: Modifier,
    inputType: InputType,
    hint : String = DataSet.Text.TEXT_HINT,
    focusColor : Color,
    icon : (@Composable () -> Unit)
){
    val text = remember {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        InputDecoration(
            inputType = inputType,
            hint = hint,
            focusColor = focusColor,
            innerTextField = {
                Input(
                    value = text.value,
                    onValueChange = { text.value = it},
                    hint = hint
                )
            }
        )
        InputDecoration(
            inputType = inputType,
            hint = hint,
            focusColor = focusColor,
            innerTextField = {
                Input(
                    value = text.value,
                    onValueChange = { text.value = it},
                    hint = hint
                )
            },
            trailingIcon = icon
        )
        InputDecoration(
            inputType = inputType,
            hint = hint,
            focusColor = focusColor,
            innerTextField = {
                Input(
                    value = text.value,
                    onValueChange = { text.value = it},
                    hint = hint
                )
            },
            leadingIcon = icon
        )
    }

}

