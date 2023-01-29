package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

@Composable
@Preview(showBackground = true)
fun ColorPreview() {
}

@Composable
fun ColorScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenAppBar(title = "ColorScreen", navController = navController)
        Text(text = "ColorScreen입니다.")
    }
}
