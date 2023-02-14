package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun AppBarPreview() {
    AppBarScreen(navController = rememberNavController())
}

@Composable
fun AppBarScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_APP_BAR, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(20.dp))
            Title2(text = "Dodam App Bar")
            Spacer(modifier = Modifier.height(10.dp))

            DodamAppBar(onStartIconClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Basic Dodam App Bar")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { /*TODO*/ }, title = "Title" )
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { /*TODO*/ }, title = "Title", startIcon = { IcAdd(contentDescription = null) })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O, StartIcon O (IcAdd)")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { /*TODO*/ }, title = "Title", endContents = { IcHome(
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(DodamDimen.AppBarDefaultIconSize))
            })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O, EndContent O (IcHome)")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
