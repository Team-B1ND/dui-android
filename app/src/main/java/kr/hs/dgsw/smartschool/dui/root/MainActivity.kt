package kr.hs.dgsw.smartschool.dui.root

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.button.IconButton
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.screen.*

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DodamTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DodamColor.Background
                ) {
                    Navigation(
                        // viewModel = viewModel,
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
        ScreenAppBar(title = "Test", navController = rememberNavController())
        // MainScreen(rememberNavController())
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun Navigation(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = modifier
    ) {
        composable("main") {
            MainScreen(navController)
        }
        composable("typo") {
            TypoScreen(navController)
        }
        composable("color") {
            ColorScreen(navController)
        }
        composable("icon") {
            IconScreen(navController)
        }
        composable("shape") {
            ShapeScreen(navController)
        }
        composable("button") {
            ButtonScreen(navController)
        }
        composable("input"){
            InputScreen(navController)
        }
        composable("select"){
            SelectScreen(navController)
        }
        composable("tab"){
            TabScreen(navController)
        }
        composable("avatar"){
            AvatarScreen(navController)
        }
        composable("banner"){
            BannerScreen(navController)
        }
        composable("bottomSheet"){
            BottomSheetScreen(navController)
        }
        composable("calender"){
            CalenderScreen(navController)
        }
        composable("appBar"){
            AppBarScreen(navController)
        }
        composable("checkBox"){
            CheckBoxScreen(navController)
        }
        composable("switch"){
            SwitchScreen(navController)
        }
    }
}

@Composable
fun ScreenAppBar(title: String, navController: NavController) {
    TopAppBar(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(DodamColor.White),
        title = { Title2(text = title) },
        navigationIcon = {
            IconButton(
                icon = { IcLeftArrow(contentDescription = null) },
                onClick = { navController.popBackStack() }
            )
        },
        elevation = 10.dp,
    )
}
@Composable
fun ItemImage(icon: Int) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .width(20.dp)
            .height(20.dp),
        Alignment.CenterEnd
    )
}
