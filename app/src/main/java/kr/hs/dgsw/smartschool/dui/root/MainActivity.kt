package kr.hs.dgsw.smartschool.dui.root

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.Item
import kr.hs.dgsw.smartschool.dui.screen.ColorScreen
import kr.hs.dgsw.smartschool.dui.screen.IconScreen
import kr.hs.dgsw.smartschool.dui.screen.MainScreen
import kr.hs.dgsw.smartschool.dui.screen.TypoScreen
import kr.hs.dgsw.smartschool.dui.ui.theme.DuiTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
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
        MainScreen(rememberNavController())
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun Navigation(
    modifier: Modifier,
    // viewModel: ViewModel,
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
    }
}

@Composable
fun ScreenAppBar(title: String, navController: NavController) {
    TopAppBar(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        title = { Text(text = title) },
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu"
                )
            }
        },
        elevation = 12.dp,
    )
}

@Composable
fun ColumnItemCard(
    item: Item,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(110.dp)
            .width(320.dp)
            .padding(vertical = 10.dp)
            .clickable {
                navController.navigate(item.route)
            },
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemImage(
                    item.icon
                )
                Title2(
                    text = item.title,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Start,
                )
            }
            Body3(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .fillMaxHeight(),
                text = item.content,
                textAlign = TextAlign.Start,
                maxLines = 2
            )
        }
    }
}

@Composable
fun ItemImage(icon: Int) {
    Surface {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
    }
}
