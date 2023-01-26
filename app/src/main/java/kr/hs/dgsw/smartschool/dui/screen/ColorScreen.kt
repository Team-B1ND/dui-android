package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kr.hs.dgsw.smartschool.components.foundation.Text


@Composable
@Preview(showBackground = true)
fun ColorPreview(){
}

@Composable
fun ColorScreen(
    viewModel: ViewModel,
    navController: NavController
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "ColorScreen입니다.")
    }
}