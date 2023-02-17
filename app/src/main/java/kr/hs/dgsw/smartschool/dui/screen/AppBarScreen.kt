package kr.hs.dgsw.smartschool.dui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcAdd
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title2
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
    val context = LocalContext.current
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

            DodamAppBar(onStartIconClick = { Toast.makeText(context, "클릭됨", Toast.LENGTH_SHORT).show() })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Basic Dodam App Bar")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { Toast.makeText(context, "클릭됨", Toast.LENGTH_SHORT).show() }, title = "Title")
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { Toast.makeText(context, "클릭됨", Toast.LENGTH_SHORT).show() }, title = "Title", startIcon = { IcAdd(contentDescription = null) })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O, StartIcon O (IcAdd)")
            Spacer(modifier = Modifier.height(20.dp))

            DodamAppBar(onStartIconClick = { Toast.makeText(context, "클릭됨", Toast.LENGTH_SHORT).show() }, title = "Title", endContents = {
                IcHome(
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(DodamDimen.AppBarDefaultIconSize)
                )
            })
            Spacer(modifier = Modifier.height(5.dp))
            Label3(text = "Title O, EndContent O (IcHome)")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
