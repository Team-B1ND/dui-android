package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.dui.compose.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun IconPreview() {
    IconScreen(navController = rememberNavController())
}

@Composable
fun IconScreen(
    // viewModel: ViewModel?,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenAppBar(title = "IconScreen", navController = navController)
        Text(text = "IconScreen입니다.")
    }
}
