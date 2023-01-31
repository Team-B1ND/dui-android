package kr.hs.dgsw.smartschool.components.component.banner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(
    imageUrls: List<String>,
    modifier: Modifier = Modifier,
    shape: Shape = DodamTheme.shape.small
) {
    HorizontalPager(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape),
        count = imageUrls.size
    ) {page ->
        GlideImage(
            modifier = Modifier.aspectRatio(36f/5f),
            imageModel = { imageUrls[page] },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
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
                "https://pbs.twimg.com/media/D20MLk8VAAAv6BI?format=jpg",
                "https://i.ytimg.com/vi/yLupcG_eFag/maxresdefault.jpg"
            )
        )
    }
}