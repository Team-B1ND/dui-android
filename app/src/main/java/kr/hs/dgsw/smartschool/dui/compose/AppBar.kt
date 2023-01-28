package kr.hs.dgsw.smartschool.dui.compose
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview(showBackground = true)
fun AppBarPreview() {
    ScreenAppBar("ScreenAppBar", navController = rememberNavController())
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
