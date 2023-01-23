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
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen("DUI")
                }
            }
        }
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun MainScreen(viewModel: ViewModel) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Send, contentDescription = "")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            ListScreen() // 리스트 뷰
        }
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
        Surface (
            modifier = Modifier.fillMaxSize()
                ){
        }
        MainScreen(name = "DUI")
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
