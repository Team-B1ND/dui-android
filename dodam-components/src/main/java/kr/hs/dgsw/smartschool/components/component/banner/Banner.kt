package kr.hs.dgsw.smartschool.components.component.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.smartschool.components.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(
    imageUrls: List<String>,
    modifier: Modifier = Modifier,
    shape: Shape = DodamTheme.shape.small,
    placeHolderBaseColor: Color = DodamTheme.color.White,
    placeHolderHighlightColor: Color = DodamTheme.color.MainColor100
) {
    HorizontalPager(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(36f/5f)
            .clip(shape),
        count = imageUrls.size
    ) {page ->
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            imageModel = { imageUrls[page] },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            ),
            component = rememberImageComponent {
                +ShimmerPlugin(
                    baseColor = placeHolderBaseColor,
                    highlightColor = placeHolderHighlightColor
                )
            },
            failure = {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.img_banner_error),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    contentDescription = null,
                )
            }
        )
    }
}

@Preview
@Composable
private fun PreviewBanner() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DodamDimen.ScreenSidePadding)
    ) {
        Banner(
            imageUrls = listOf(
                "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png"
            )
        )
    }
}