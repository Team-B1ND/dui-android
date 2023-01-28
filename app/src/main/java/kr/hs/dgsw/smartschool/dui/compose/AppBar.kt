package kr.hs.dgsw.smartschool.dui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.Surface
import kr.hs.dgsw.smartschool.components.component.button.IconButton

@Composable
@Preview(showBackground = true)
fun AppBarPreview(){
        ScreenAppBar("ScreenAppBar",navController = rememberNavController())
}

@Composable
fun ScreenAppBar(title:String, navController: NavController) {
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