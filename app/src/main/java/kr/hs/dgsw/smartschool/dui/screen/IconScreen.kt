package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.dui.root.ScreenAppBar

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
            .background(DodamColor.White)
    ) {
        ScreenAppBar(title = "IconScreen", navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title2(text = "기본 아이콘")
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

            ){
                Icon2D(icon = { IcAdd(contentDescription = null)}, name = "Add")
                Icon2D(icon = { IcLeftArrow(contentDescription = null) }, name = "Left Arrow")
                Icon2D(icon = { IcRightArrow(contentDescription = null) }, name = "Right Arrow")
                Icon2D(icon = { IcHome(contentDescription = null) }, name = "Home")
                Icon2D(icon = { IcMeal(contentDescription = null) }, name = "Meal")
            }
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

                ){
                Icon2D(icon = { IcSong(contentDescription = null) }, name = "Song")
                Icon2D(icon = { IcX(contentDescription = null) }, name = "User")
                Icon2D(icon = { IcDelete(contentDescription = null) }, name = "Delete")
                Icon2D(icon = { IcGallery(contentDescription = null) }, name = "Gallery")
                Icon2D(icon = { IcSearch(contentDescription = null) }, name = "Search")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Title2(text = "3D 아이콘")
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),

                ){
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

                ){
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

                ){
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
    icon : (@Composable () -> Unit),
    name : String
){
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
        if(clicked.value){
            Spacer(modifier = Modifier.height(10.dp))
            Label3(text = name)
        }
    }
}

@Composable
fun Icon3D(
    icon : (@Composable () -> Unit),
    name : String
){
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
        if(clicked.value){
            Label3(text = name)
        }
    }
}


