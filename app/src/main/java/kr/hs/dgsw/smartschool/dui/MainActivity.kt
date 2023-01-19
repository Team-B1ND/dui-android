package kr.hs.dgsw.smartschool.dui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.component.button.ButtonType
import kr.hs.dgsw.smartschool.components.component.button.DodamLargeRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.DodamSmallRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.IconButton
import kr.hs.dgsw.smartschool.components.component.button.RadioButton
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.theme.Body1
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.Display1
import kr.hs.dgsw.smartschool.components.theme.Display2
import kr.hs.dgsw.smartschool.components.theme.Display3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamError
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Headline1
import kr.hs.dgsw.smartschool.components.theme.Headline2
import kr.hs.dgsw.smartschool.components.theme.Headline3
import kr.hs.dgsw.smartschool.components.theme.IcBreakfast3D
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow
import kr.hs.dgsw.smartschool.components.theme.IcSong
import kr.hs.dgsw.smartschool.components.theme.IcX
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.theme.Title3
import kr.hs.dgsw.smartschool.dui.ui.theme.DuiTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DodamTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DodamColor.Background
                ) {
                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(scrollState),
                    ) {
                        DodamDisplayText()
                        DodamHeadlineText()
                        DodamTitleText()
                        DodamLabelText()
                        DodamBodyText()
                        DodamError(text = "도담도담 Error Text")
                        IcBreakfast3D(contentDescription = null)
                        DodamSmallRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Small")
                        Spacer(modifier = Modifier.height(8.dp))
                        DodamMediumRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "도담도담 버튼", type = ButtonType.Danger, iconLeft = { IcSong(contentDescription = null) })
                        Spacer(modifier = Modifier.height(8.dp))
                        DodamLargeRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Large", type = ButtonType.Disable, enable = false)
                        Spacer(modifier = Modifier.height(8.dp))
                        IconButton(icon = { IcSong(contentDescription = null) }, onClick = { sampleOnClick(this@MainActivity) }, type = ButtonType.Danger)

                        Spacer(modifier = Modifier.height(8.dp))

                        val radioState = remember { mutableStateOf(true) }
                        Row {
                            RadioButton(selected = radioState.value, onClick = { radioState.value = !radioState.value }, type = ButtonType.Itmap)
                            Spacer(modifier = Modifier.width(8.dp))
                            Body2(text = "Radio", modifier = Modifier.align(Alignment.CenterVertically))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val testValue = remember { mutableStateOf("") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = testValue.value,
                            hint = "테스트 값을 입력해 주세요!",
                            onValueChange = { testValue.value = it },
                            focusColor = DodamColor.FeatureColor.LostFoundColor,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        val value = remember { mutableStateOf("Test Input") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = value.value,
                            hint = "Test Hint",
                            onValueChange = { value.value = it },
                            leadingIcon = { IcSong(contentDescription = null) },
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        val value2 = remember { mutableStateOf("Test Input2") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = value2.value,
                            hint = "Test Hint2",
                            isError = true,
                            errorMessage = "응애 에러 발생 에러 발생",
                            onValueChange = { value2.value = it },
                            trailingIcon = { IcX(contentDescription = null, modifier = Modifier.clickable { value2.value = "" }) },
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun DodamDisplayText() {
    Column {
        Display1(text = "도담도담 Display1", onClick = {}, rippleColor = DodamColor.MainColor)
        Display2(text = "도담도담 Display2")
        Display3(text = "도담도담 Display3")
    }
}

@Composable
fun DodamHeadlineText() {
    Column {
        Headline1(text = "도담도담 Headline1")
        Headline2(text = "도담도담 Headline2")
        Headline3(text = "도담도담 Headline3")
    }
}

@Composable
fun DodamTitleText() {
    Column {
        Title1(text = "도담도담 Title1")
        Title2(text = "도담도담 Title2")
        Title3(text = "도담도담 Title3")
    }
}

@Composable
fun DodamLabelText() {
    Column {
        Label1(text = "도담도담 Label1")
        Label2(text = "도담도담 Label2")
        Label3(text = "도담도담 Label3")
    }
}

@Composable
fun DodamBodyText() {
    Column {
        Body1(text = "도담도담 Body1")
        Body2(text = "도담도담 Body2")
        Body3(text = "도담도담 Body3")
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayTextPreview() {
    DuiTheme {
        DodamDisplayText()
    }
}

@Preview(showBackground = true)
@Composable
fun HeadlineTextPreview() {
    DuiTheme {
        DodamHeadlineText()
    }
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    DuiTheme {
        DodamTitleText()
    }
}

@Preview(showBackground = true)
@Composable
fun LabelTextPreview() {
    DuiTheme {
        DodamLabelText()
    }
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    DuiTheme {
        DodamBodyText()
    }
}

@Preview(showBackground = true)
@Composable
fun IcBack() {
    IcLeftArrow(contentDescription = null, tint = DodamColor.MainColor)
}

@Preview(showBackground = true)
@Composable
fun ErrorTextPreview() {
    DuiTheme {
        DodamError(text = "도담도담 Error Text")
    }
}
