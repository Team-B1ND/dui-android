package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
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
import kr.hs.dgsw.smartschool.components.component.set.banner.Banner
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.dgsw.smartschool.dui.DataSet

@Composable
@Preview(showBackground = true)
fun BannerPreview() {
    BannerScreen(navController = rememberNavController())
}

@Composable
fun BannerScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.White)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_BANNER, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(DodamColor.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(DodamDimen.ScreenSidePadding)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Title2(text = "Banner")
                Spacer(modifier = Modifier.height(10.dp))
                Body2(text = "indicator O, 배너 여러 개")
                Spacer(modifier = Modifier.height(10.dp))
                Banner(
                    imageUrls = listOf(
                        "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                        "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                        "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Body2(text = "indicator O, 배너 한 개")
                Spacer(modifier = Modifier.height(10.dp))
                Banner(
                    imageUrls = listOf(
                        "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Body2(text = "indicator X, 배너 여러 개")
                Spacer(modifier = Modifier.height(10.dp))
                Banner(
                    imageUrls = listOf(
                        "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                        "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                        "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                    ),
                    showIndicator = false
                )
            }
        }
    }
}
