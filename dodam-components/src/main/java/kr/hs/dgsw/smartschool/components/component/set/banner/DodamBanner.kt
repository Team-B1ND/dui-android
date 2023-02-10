package kr.hs.dgsw.smartschool.components.component.set.banner

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import kotlinx.coroutines.launch
import kr.hs.dgsw.smartschool.components.component.basic.badge.DodamBadgeBox
import kr.hs.dgsw.smartschool.components.component.basic.indicator.DodamPagerIndicator
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import kr.hs.smartschool.components.R

/**
 * Dodam basic banner using pager
 *
 * @param imageUrls banner image urls, use list type
 * @param modifier modifier
 * @param ratio Banner ratio, 36f / 5f
 * @param shape Banner shape, 5.dp
 * @param showIndicator visibility of indicator, if page count is one, not show indicator
 * @param placeHolderBaseColor base color when loading
 * @param placeHolderHighlightColor highlight color when loading
 * @param onClick action when click banner
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun DodamBanner(
    imageUrls: List<String>,
    modifier: Modifier = Modifier,
    ratio: Float = 36f / 5f,
    shape: Shape = DodamTheme.shape.small,
    showIndicator: Boolean = true,
    placeHolderBaseColor: Color = DodamTheme.color.White,
    placeHolderHighlightColor: Color = DodamTheme.color.MainColor100,
    onClick: ((page: Int) -> Unit)? = null,
) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Box {
        HorizontalPager(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(ratio)
                .clip(shape),
            count = imageUrls.size,
            state = pagerState
        ) { page ->
            GlideImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ) { onClick?.let { it(page) } },
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

        if (showIndicator && imageUrls.size > 1)
            DodamBadgeBox(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 6.dp, end = 6.dp),
                background = DodamTheme.color.Gray200.copy(alpha = 0.8f),
                contentPaddingValues = PaddingValues(horizontal = 6.dp, vertical = 1.dp)
            ) {
                DodamPagerIndicator(
                    pagerState = pagerState,
                    indicatorCount = imageUrls.size,
                ) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(it)
                    }
                }
            }
    }
}

@Preview
@Composable
private fun PreviewBanner() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DodamDimen.ScreenSidePadding)
    ) {
        DodamBanner(
            imageUrls = listOf(
                "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        DodamBanner(
            imageUrls = listOf(
                "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        DodamBanner(
            imageUrls = listOf(
                "https://dodam.kr.object.ncloudstorage.com/dodam/c70c7b96-dd67-4467-a49c-2d0baa459624TEAM%20B1ND%20Banner.png",
                "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
                "https://dodam.kr.object.ncloudstorage.com/dodam/be5fa717-a286-42e8-bcb3-40c57bfd61cbB1ND%20%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%20%E1%84%8E%E1%85%A2%E1%84%8B%E1%85%AD%E1%86%BCbanner%20(1).png",
            ),
            showIndicator = false,
            onClick = { currentPage ->
                Toast.makeText(context, currentPage.toString(), Toast.LENGTH_SHORT).show()
            }
        )
    }
}
