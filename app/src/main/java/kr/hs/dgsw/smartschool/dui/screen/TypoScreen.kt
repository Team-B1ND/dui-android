package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import kr.hs.dgsw.smartschool.components.component.basic.input.DodamInput
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.Body1
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.Display2
import kr.hs.dgsw.smartschool.components.theme.Display3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamError
import kr.hs.dgsw.smartschool.components.theme.DodamTypography
import kr.hs.dgsw.smartschool.components.theme.Headline1
import kr.hs.dgsw.smartschool.components.theme.Headline2
import kr.hs.dgsw.smartschool.components.theme.Headline3
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.theme.Title3
import kr.hs.dgsw.smartschool.dui.DataSet

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

data class FontSpec(
    val fontFamily: String,
    val fontWeight: String,
    val fontSize: String,
    val lineHeight: String
)

@Composable
fun TypoScreen(
    navController: NavController
) {
    val fontFamily = "pretendard"
    val textState = remember {
        mutableStateOf("텍스트 입력")
    }
    val fontState = remember {
        mutableStateOf(
            FontSpec(
                "pretendard",
                DodamTypography.display1.fontWeight.toString(),
                DodamTypography.display1.fontSize.toString(),
                DodamTypography.display1.lineHeight.toString()
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_TYPO, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            DodamInput(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .width(320.dp),
                hint = "텍스트를 입력해주세요..."
            )
            Spacer(modifier = Modifier.height(20.dp))
            Label1(text = "fontFamily = ${fontState.value.fontFamily}")
            Label1(text = "fontWeight = ${fontState.value.fontWeight}")
            Label1(text = "fontSize = ${fontState.value.fontSize}")
            Label1(text = "lineHeight = ${fontState.value.lineHeight}")
            Spacer(modifier = Modifier.height(10.dp))
            TypoTitle(text = "Display")

            // Display1
            Spacer(modifier = Modifier.height(20.dp))
            Display1(
                text = "Display1",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display1.fontWeight.toString(),
                                DodamTypography.display1.fontSize.toString(),
                                DodamTypography.display1.lineHeight.toString()
                            )
                    }
            )
            Display1(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display1.fontWeight.toString(),
                                DodamTypography.display1.fontSize.toString(),
                                DodamTypography.display1.lineHeight.toString()
                            )
                    }
            )

            // Display2
            Spacer(modifier = Modifier.height(10.dp))
            Display2(
                text = "Display2",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display2.fontWeight.toString(),
                                DodamTypography.display2.fontSize.toString(),
                                DodamTypography.display2.lineHeight.toString()
                            )
                    }
            )
            Display2(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display2.fontWeight.toString(),
                                DodamTypography.display2.fontSize.toString(),
                                DodamTypography.display2.lineHeight.toString()
                            )
                    }
            )

            // Display3
            Spacer(modifier = Modifier.height(10.dp))
            Display3(
                text = "Display3",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display3.fontWeight.toString(),
                                DodamTypography.display3.fontSize.toString(),
                                DodamTypography.display3.lineHeight.toString()
                            )
                    }
            )
            Display3(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.display3.fontWeight.toString(),
                                DodamTypography.display3.fontSize.toString(),
                                DodamTypography.display3.lineHeight.toString()
                            )
                    }
            )

            TypoTitle(text = "HeadLine")

            // HeadLine1
            Spacer(modifier = Modifier.height(10.dp))
            Headline1(
                text = "Headline1",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline1.fontWeight.toString(),
                                DodamTypography.headline1.fontSize.toString(),
                                DodamTypography.headline1.lineHeight.toString()
                            )
                    }
            )
            Headline1(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline1.fontWeight.toString(),
                                DodamTypography.headline1.fontSize.toString(),
                                DodamTypography.headline1.lineHeight.toString()
                            )
                    }
            )

            // HeadLine2
            Spacer(modifier = Modifier.height(10.dp))
            Headline2(
                text = "Headline2",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline2.fontWeight.toString(),
                                DodamTypography.headline2.fontSize.toString(),
                                DodamTypography.headline2.lineHeight.toString()
                            )
                    }
            )
            Headline2(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline2.fontWeight.toString(),
                                DodamTypography.headline2.fontSize.toString(),
                                DodamTypography.headline2.lineHeight.toString()
                            )
                    }
            )

            // HeadLine3
            Spacer(modifier = Modifier.height(10.dp))
            Headline3(
                text = "Headline3",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline3.fontWeight.toString(),
                                DodamTypography.headline3.fontSize.toString(),
                                DodamTypography.headline3.lineHeight.toString()
                            )
                    }
            )
            Headline3(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.headline3.fontWeight.toString(),
                                DodamTypography.headline3.fontSize.toString(),
                                DodamTypography.headline3.lineHeight.toString()
                            )
                    }
            )

            TypoTitle(text = "Title")

            // Title1
            Spacer(modifier = Modifier.height(10.dp))
            Title1(
                text = "Title1",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title1.fontWeight.toString(),
                                DodamTypography.title1.fontSize.toString(),
                                DodamTypography.title1.lineHeight.toString()
                            )
                    }
            )
            Title1(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title1.fontWeight.toString(),
                                DodamTypography.title1.fontSize.toString(),
                                DodamTypography.title1.lineHeight.toString()
                            )
                    }
            )

            // Title2
            Spacer(modifier = Modifier.height(10.dp))
            Title2(
                text = "Title2",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title2.fontWeight.toString(),
                                DodamTypography.title2.fontSize.toString(),
                                DodamTypography.title2.lineHeight.toString()
                            )
                    }
            )
            Title2(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title2.fontWeight.toString(),
                                DodamTypography.title2.fontSize.toString(),
                                DodamTypography.title2.lineHeight.toString()
                            )
                    }
            )

            // Title3
            Spacer(modifier = Modifier.height(10.dp))
            Title3(
                text = "Title3",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title3.fontWeight.toString(),
                                DodamTypography.title3.fontSize.toString(),
                                DodamTypography.title3.lineHeight.toString()
                            )
                    }
            )
            Title3(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.title3.fontWeight.toString(),
                                DodamTypography.title3.fontSize.toString(),
                                DodamTypography.title3.lineHeight.toString()
                            )
                    }
            )

            TypoTitle(text = "Body")

            // Body1
            Spacer(modifier = Modifier.height(10.dp))
            Body1(
                text = "Body1",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body1.fontWeight.toString(),
                                DodamTypography.body1.fontSize.toString(),
                                DodamTypography.body1.lineHeight.toString()
                            )
                    }
            )
            Body1(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body1.fontWeight.toString(),
                                DodamTypography.body1.fontSize.toString(),
                                DodamTypography.body1.lineHeight.toString()
                            )
                    }
            )

            // Body2
            Spacer(modifier = Modifier.height(10.dp))
            Body2(
                text = "Body2",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body2.fontWeight.toString(),
                                DodamTypography.body2.fontSize.toString(),
                                DodamTypography.body2.lineHeight.toString()
                            )
                    }
            )
            Body2(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body2.fontWeight.toString(),
                                DodamTypography.body2.fontSize.toString(),
                                DodamTypography.body2.lineHeight.toString()
                            )
                    }
            )

            // Body3
            Spacer(modifier = Modifier.height(10.dp))
            Body3(
                text = "Body3",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body3.fontWeight.toString(),
                                DodamTypography.body3.fontSize.toString(),
                                DodamTypography.body3.lineHeight.toString()
                            )
                    }
            )
            Body3(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body3.fontWeight.toString(),
                                DodamTypography.body3.fontSize.toString(),
                                DodamTypography.body3.lineHeight.toString()
                            )
                    }
            )

            TypoTitle(text = "Label")

            // Label1
            Spacer(modifier = Modifier.height(10.dp))
            Label1(
                text = "Label1",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label1.fontWeight.toString(),
                                DodamTypography.label1.fontSize.toString(),
                                DodamTypography.label1.lineHeight.toString()
                            )
                    }
            )
            Label1(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label1.fontWeight.toString(),
                                DodamTypography.label1.fontSize.toString(),
                                DodamTypography.label1.lineHeight.toString()
                            )
                    }
            )

            // Label2
            Spacer(modifier = Modifier.height(10.dp))
            Label2(
                text = "Label2",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label2.fontWeight.toString(),
                                DodamTypography.label2.fontSize.toString(),
                                DodamTypography.label2.lineHeight.toString()
                            )
                    }
            )
            Label2(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label2.fontWeight.toString(),
                                DodamTypography.label2.fontSize.toString(),
                                DodamTypography.label2.lineHeight.toString()
                            )
                    }
            )

            // Label3
            Spacer(modifier = Modifier.height(10.dp))
            Label3(
                text = "Label3",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label3.fontWeight.toString(),
                                DodamTypography.label3.fontSize.toString(),
                                DodamTypography.label3.lineHeight.toString()
                            )
                    }
            )
            Label3(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.label3.fontWeight.toString(),
                                DodamTypography.label3.fontSize.toString(),
                                DodamTypography.label3.lineHeight.toString()
                            )
                    }
            )

            TypoTitle(text = "DodamError")

            // Error
            Spacer(modifier = Modifier.height(10.dp))
            DodamError(
                text = "DodamError",
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body3.fontWeight.toString(),
                                DodamTypography.body3.fontSize.toString(),
                                DodamTypography.body3.lineHeight.toString()
                            )
                    }
            )
            DodamError(
                text = textState.value,
                modifier = Modifier
                    .dodamClickable {
                        fontState.value =
                            FontSpec(
                                fontFamily,
                                DodamTypography.body3.fontWeight.toString(),
                                DodamTypography.body3.fontSize.toString(),
                                DodamTypography.body3.lineHeight.toString()
                            )
                    }
            )

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
            .background(DodamColor.White)
    )
}
