package kr.hs.dgsw.smartschool.dui.root

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.dui.screen.ColorScreen
import kr.hs.dgsw.smartschool.dui.screen.IconScreen
import kr.hs.dgsw.smartschool.dui.screen.MainScreen
import kr.hs.dgsw.smartschool.dui.screen.TypoScreen
import kr.hs.dgsw.smartschool.dui.ui.theme.DuiTheme
import kr.hs.dgsw.smartschool.dui.viewmodel.MainViewModel

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DuiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DodamColor.Background
                ) {
                    Navigation(
                        viewModel = viewModel,
                        navController = navController,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        MainScreen(viewModel = null, rememberNavController())
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun Navigation(modifier: Modifier, viewModel: ViewModel, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = modifier
    ) {
        composable("main") {
            MainScreen(viewModel, navController)
        }
        composable("typo") {
            TypoScreen(viewModel, navController)
        }
        composable("color") {
            ColorScreen(viewModel, navController)
        }
        composable("icon") {
            IconScreen(viewModel, navController)
        }
    }
}

/*val scrollState = rememberScrollState()
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
}*/
