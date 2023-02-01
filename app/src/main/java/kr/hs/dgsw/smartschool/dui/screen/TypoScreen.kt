package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.TextField
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
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.component.input.InputArea
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun TypoPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TypoScreen(navController = rememberNavController())
    }
}

@Composable
fun TypoScreen(
    navController: NavController
) {
    val textState = remember {
        mutableStateOf("문자를 입력하세요")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenAppBar(title = "TypoScreen", navController = navController)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(320.dp)
                .scrollable(rememberScrollState(),Orientation.Vertical),
            horizontalAlignment = Alignment.Start

        ) {
            TextField(
                value = textState.value,
                onValueChange = {textValue -> textState.value = textValue},
                modifier = Modifier
                    .width(320.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Title1(
                text = "HeadLine",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DodamColor.Background)
            )

            //HeadLine1
            Spacer(modifier = Modifier.height(10.dp))
            Headline1(text = "Headline1")
            Headline1(text = textState.value)

            //HeadLine2
            Spacer(modifier = Modifier.height(10.dp))
            Headline2(text = "Headline2")
            Headline2(text = textState.value)

            //HeadLine3
            Spacer(modifier = Modifier.height(10.dp))
            Headline3(text = "Headline3")
            Headline3(text = textState.value)

            Spacer(modifier = Modifier.height(20.dp))
            Title1(
                text = "Title",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DodamColor.Background)
            )

            //Title1
            Spacer(modifier = Modifier.height(10.dp))
            Title1(text = "Title1")
            Title1(text = textState.value)

            //Title2
            Spacer(modifier = Modifier.height(10.dp))
            Title2(text = "Title2")
            Title2(text = textState.value)

            //Title3
            Spacer(modifier = Modifier.height(10.dp))
            Title3(text = "Title3")
            Title3(text = textState.value)

            Spacer(modifier = Modifier.height(20.dp))
            Title1(
                text = "Body",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DodamColor.Background)
            )

            //Body1
            Spacer(modifier = Modifier.height(10.dp))
            Body1(text = "Body1")
            Body1(text = textState.value)

            //Body2
            Spacer(modifier = Modifier.height(10.dp))
            Body2(text = "Body2")
            Body2(text = textState.value)

            //Body3
            Spacer(modifier = Modifier.height(10.dp))
            Body3(text = "Body3")
            Body3(text = textState.value)
            
            Spacer(modifier = Modifier.height(20.dp))
            Title1(
                text = "Label",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DodamColor.Background)
            )

            //Label1
            Spacer(modifier = Modifier.height(10.dp))
            Label1(text = "Label1")
            Label1(text = textState.value)

            //Label2
            Spacer(modifier = Modifier.height(10.dp))
            Label2(text = "Label2")
            Label2(text = textState.value)

            //Label3
            Spacer(modifier = Modifier.height(10.dp))
            Label3(text = "Label3")
            Label3(text = textState.value)
        }
    }
}