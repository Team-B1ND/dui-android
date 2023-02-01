package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
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
import kr.hs.dgsw.smartschool.components.theme.Body1
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.Display2
import kr.hs.dgsw.smartschool.components.theme.Display3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamError
import kr.hs.dgsw.smartschool.components.theme.Headline1
import kr.hs.dgsw.smartschool.components.theme.Headline2
import kr.hs.dgsw.smartschool.components.theme.Headline3
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.theme.Title3
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
        mutableStateOf("텍스트 입력")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenAppBar(title = "TypoScreen", navController = navController)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = textState.value,
            onValueChange = { textValue -> textState.value = textValue },
            modifier = Modifier
                .width(320.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp)
                .verticalScroll(rememberScrollState())
                .background(DodamColor.White),
            horizontalAlignment = Alignment.Start

        ) {
            Spacer(modifier = Modifier.height(20.dp))
            TypoTitle(text = "Display")

            // Display1
            Spacer(modifier = Modifier.height(10.dp))
            Display1(text = "Display1")
            Display1(text = textState.value)

            // Display2
            Spacer(modifier = Modifier.height(10.dp))
            Display2(text = "Display2")
            Display2(text = textState.value)

            // Display3
            Spacer(modifier = Modifier.height(10.dp))
            Display3(text = "Display3")
            Display3(text = textState.value)

            TypoTitle(text = "HeadLine")

            // HeadLine1
            Spacer(modifier = Modifier.height(10.dp))
            Headline1(text = "Headline1")
            Headline1(text = textState.value)

            // HeadLine2
            Spacer(modifier = Modifier.height(10.dp))
            Headline2(text = "Headline2")
            Headline2(text = textState.value)

            // HeadLine3
            Spacer(modifier = Modifier.height(10.dp))
            Headline3(text = "Headline3")
            Headline3(text = textState.value)

            TypoTitle(text = "Title")

            // Title1
            Spacer(modifier = Modifier.height(10.dp))
            Title1(text = "Title1")
            Title1(text = textState.value)

            // Title2
            Spacer(modifier = Modifier.height(10.dp))
            Title2(text = "Title2")
            Title2(text = textState.value)

            // Title3
            Spacer(modifier = Modifier.height(10.dp))
            Title3(text = "Title3")
            Title3(text = textState.value)

            TypoTitle(text = "Body")

            // Body1
            Spacer(modifier = Modifier.height(10.dp))
            Body1(text = "Body1")
            Body1(text = textState.value)

            // Body2
            Spacer(modifier = Modifier.height(10.dp))
            Body2(text = "Body2")
            Body2(text = textState.value)

            // Body3
            Spacer(modifier = Modifier.height(10.dp))
            Body3(text = "Body3")
            Body3(text = textState.value)

            TypoTitle(text = "Label")

            // Label1
            Spacer(modifier = Modifier.height(10.dp))
            Label1(text = "Label1")
            Label1(text = textState.value)

            // Label2
            Spacer(modifier = Modifier.height(10.dp))
            Label2(text = "Label2")
            Label2(text = textState.value)

            // Label3
            Spacer(modifier = Modifier.height(10.dp))
            Label3(text = "Label3")
            Label3(text = textState.value)

            TypoTitle(text = "DodamError")

            // Error
            Spacer(modifier = Modifier.height(10.dp))
            DodamError(text = "DodamError")
            DodamError(text = textState.value)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun TypoTitle(
    text: String
) {
    Spacer(modifier = Modifier.height(20.dp))
    Title1(
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(DodamColor.Background)
    )
}
