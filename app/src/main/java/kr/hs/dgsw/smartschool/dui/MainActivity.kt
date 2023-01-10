package kr.hs.dgsw.smartschool.dui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.button.ButtonType
import kr.hs.dgsw.smartschool.components.component.button.DodamLargeRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.DodamSmallRoundedButton
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
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title1
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.theme.Title3
import kr.hs.dgsw.smartschool.dui.ui.theme.DuiTheme

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
                            .padding(5.dp)
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
                        DodamMediumRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Medium", type = ButtonType.Danger)
                        Spacer(modifier = Modifier.height(8.dp))
                        DodamLargeRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Large", type = ButtonType.Disable, enable = false)
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
