package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.IcAdd
import kr.hs.dgsw.smartschool.components.theme.IcBreakfast3D
import kr.hs.dgsw.smartschool.components.theme.IcBus3D
import kr.hs.dgsw.smartschool.components.theme.IcDelete
import kr.hs.dgsw.smartschool.components.theme.IcDinner3D
import kr.hs.dgsw.smartschool.components.theme.IcDocument3D
import kr.hs.dgsw.smartschool.components.theme.IcGallery
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.IcInfo3D
import kr.hs.dgsw.smartschool.components.theme.IcItmap3D
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow
import kr.hs.dgsw.smartschool.components.theme.IcLock3D
import kr.hs.dgsw.smartschool.components.theme.IcLogout3D
import kr.hs.dgsw.smartschool.components.theme.IcLostFound3D
import kr.hs.dgsw.smartschool.components.theme.IcLunch3D
import kr.hs.dgsw.smartschool.components.theme.IcMeal
import kr.hs.dgsw.smartschool.components.theme.IcOut3D
import kr.hs.dgsw.smartschool.components.theme.IcPoint3D
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.theme.IcSearch
import kr.hs.dgsw.smartschool.components.theme.IcSetting3D
import kr.hs.dgsw.smartschool.components.theme.IcSong
import kr.hs.dgsw.smartschool.components.theme.IcSong3D
import kr.hs.dgsw.smartschool.components.theme.IcUser
import kr.hs.dgsw.smartschool.components.theme.IcX
import kr.hs.dgsw.smartschool.components.theme.Label3
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun IconPreview() {
    IconScreen(navController = rememberNavController())
}

@Composable
fun IconScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_ICON, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamColor.Background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = "기본 아이콘")
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon2D(icon = { IcAdd(contentDescription = null) }, name = "Add")
                Icon2D(icon = { IcLeftArrow(contentDescription = null) }, name = "Left Arrow")
                Icon2D(icon = { IcRightArrow(contentDescription = null) }, name = "Right Arrow")
                Icon2D(icon = { IcHome(contentDescription = null) }, name = "Home")
                Icon2D(icon = { IcMeal(contentDescription = null) }, name = "Meal")
            }
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon2D(icon = { IcSong(contentDescription = null) }, name = "Song")
                Icon2D(icon = { IcX(contentDescription = null) }, name = "X")
                Icon2D(icon = { IcDelete(contentDescription = null) }, name = "Delete")
                Icon2D(icon = { IcGallery(contentDescription = null) }, name = "Gallery")
                Icon2D(icon = { IcSearch(contentDescription = null) }, name = "Search")
            }
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon2D(icon = { IcUser(contentDescription = null) }, name = "User")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Title2(text = "3D 아이콘")
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon3D(icon = { IcBreakfast3D(contentDescription = null) }, name = "Breakfast")
                Icon3D(icon = { IcDinner3D(contentDescription = null) }, name = "Dinner")
                Icon3D(icon = { IcLunch3D(contentDescription = null) }, name = "Lunch")
                Icon3D(icon = { IcSong3D(contentDescription = null) }, name = "Song")
                Icon3D(icon = { IcOut3D(contentDescription = null) }, name = "Out")
            }
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon3D(icon = { IcItmap3D(contentDescription = null) }, name = "ItMap")
                Icon3D(icon = { IcLostFound3D(contentDescription = null) }, name = "LostFound")
                Icon3D(icon = { IcPoint3D(contentDescription = null) }, name = "Point")
                Icon3D(icon = { IcBus3D(contentDescription = null) }, name = "Bus")
                Icon3D(icon = { IcSetting3D(contentDescription = null) }, name = "Setting")
            }
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ) {
                Icon3D(icon = { IcDocument3D(contentDescription = null) }, name = "Document")
                Icon3D(icon = { IcInfo3D(contentDescription = null) }, name = "Info")
                Icon3D(icon = { IcLock3D(contentDescription = null) }, name = "Lock")
                Icon3D(icon = { IcLogout3D(contentDescription = null) }, name = "Logout")
            }
        }
    }
}

@Composable
fun Icon2D(
    icon: (@Composable () -> Unit),
    name: String
) {
    val clicked = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .size(70.dp)
            .dodamClickable {
                clicked.value = !clicked.value
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        if (clicked.value) {
            Spacer(modifier = Modifier.height(10.dp))
            Label3(text = name)
        }
    }
}

@Composable
fun Icon3D(
    icon: (@Composable () -> Unit),
    name: String
) {
    val clicked = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .size(70.dp)
            .dodamClickable {
                clicked.value = !clicked.value
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        if (clicked.value) {
            Label3(text = name)
        }
    }
}
