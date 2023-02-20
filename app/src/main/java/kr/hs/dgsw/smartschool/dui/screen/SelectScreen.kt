package kr.hs.dgsw.smartschool.dui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.input.DodamSelect
import kr.hs.dgsw.smartschool.components.component.basic.input.area.DodamSelectArea
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun SelectPreview() {
    SelectScreen(navController = rememberNavController())
}

@Composable
fun SelectScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_SELECT, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = DodamDimen.ScreenSidePadding)
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Select")
            Spacer(modifier = Modifier.height(10.dp))
            SampleSelect(modifier = Modifier)
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "Dodam Select Area")
            Spacer(modifier = Modifier.height(10.dp))
            SampleSelectArea(modifier = Modifier)
        }
    }
}

@Composable
fun SampleSelect(
    modifier: Modifier,
) {
    val isError = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    Column(modifier = modifier) {
        DodamSelect(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            hint = "Hint",
            focusColor = DodamColor.MainColor,
            modifier = Modifier.width(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        DodamSelect(
            itemList = sampleList,
            onItemClickListener = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                isError.value = it == "Error"
            },
            hint = "Error 테스트",
            isError = isError.value,
            focusColor = if (isError.value) DodamColor.Error else DodamColor.MainColor,
            errorMessage = if (isError.value) "Error Message" else "",
            modifier = Modifier.width(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        DodamSelect(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = false,
            hint = "사이즈 조정 & 직접 입력 가능",
            focusColor = DodamColor.MainColor,
        )
    }
}

@Composable
fun SampleSelectArea(
    modifier: Modifier
) {
    val isError = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Column(modifier = modifier) {
        DodamSelectArea(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            hint = "Hint",
            focusColor = DodamColor.MainColor,
        )

        Spacer(modifier = Modifier.height(20.dp))

        DodamSelectArea(
            itemList = sampleList,
            onItemClickListener = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                isError.value = it == "Error"
            },
            hint = "Error 테스트",
            isError = isError.value,
            focusColor = if (isError.value) DodamColor.Error else DodamColor.MainColor,
        )

        Spacer(modifier = Modifier.height(20.dp))

        DodamSelectArea(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = false,
            hint = "사이즈 조정 & 직접 입력 가능",
            focusColor = DodamColor.MainColor,
        )
    }
}

private val sampleList = listOf<String>(
    "Default",
    "Error",
    "Dummy",
    "Dummy"
)
