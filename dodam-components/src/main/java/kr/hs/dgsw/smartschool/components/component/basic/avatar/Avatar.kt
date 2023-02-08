package kr.hs.dgsw.smartschool.components.component.basic.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import kr.hs.dgsw.smartschool.components.component.basic.surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcUser
import kr.hs.smartschool.components.R

/**
 * Dodam Avatar, can express saved image
 *
 * @param painter profile image
 * @param modifier modifier
 * @param shape shape of avatar, basic is circle
 * @param size avatar circle size, basic is 40.dp
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click avatar
 */
@Composable
fun Avatar(
    painter: Painter,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .size(size)
    ) {
        Image(
            modifier = Modifier
                .clip(shape)
                .fillMaxSize()
                .dodamClickable(
                    onClick = onClick,
                    rippleColor = rippleColor,
                    rippleEnable = rippleEnable,
                    bounded = bounded
                ),
            painter = painter,
            contentDescription = null
        )
    }
}

/**
 * Dodam Avatar, can express first word of name
 *
 * @param name show first word
 * @param modifier modifier
 * @param nameStyle text Style
 * @param nameColor text Color
 * @param backgroundColor color for circle background
 * @param shape shape of avatar, basic is circle
 * @param size avatar circle size, basic is 40.dp
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click avatar
 */
@Composable
fun Avatar(
    name: String,
    modifier: Modifier = Modifier,
    nameStyle: TextStyle = DodamTheme.typography.title2,
    nameColor: Color = DodamTheme.color.Gray400,
    backgroundColor: Color = DodamTheme.color.Background,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, backgroundColor)
            .dodamClickable(
                onClick = onClick,
                rippleColor = rippleColor,
                rippleEnable = rippleEnable,
                bounded = bounded
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name.take(1),
            style = nameStyle,
            color = nameColor,
        )
    }
}

/**
 * Dodam Avatar, can express icon center
 *
 * @param modifier modifier
 * @param iconSize icon's size
 * @param iconColor icon's color
 * @param backgroundColor color for circle background
 * @param shape shape of avatar, basic is circle
 * @param size avatar circle size, basic is 40.dp
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click avatar
 */
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    iconSize: Dp = 20.dp,
    iconColor: Color = DodamTheme.color.Gray400,
    backgroundColor: Color = DodamTheme.color.Background,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, backgroundColor)
            .dodamClickable(
                onClick = onClick,
                rippleColor = rippleColor,
                rippleEnable = rippleEnable,
                bounded = bounded
            ),
        contentAlignment = Alignment.Center
    ) {
        IcUser(
            modifier = modifier.size(iconSize),
            tint = iconColor,
            contentDescription = null,
        )
    }
}

/**
 * Dodam Avatar, can express remote image
 *
 * @param link remote image link
 * @param modifier modifier
 * @param backgroundColor color for circle background
 * @param shape shape of avatar, basic is circle
 * @param size avatar circle size, basic is 40.dp
 * @param placeHolderBaseColor loading place circle base color
 * @param placeHolderHighlightColor loading place highlight bar color
 * @param failureIconSize icon size when fail to load image
 * @param failureIconColor icon color when fail to load image
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click avatar
 */
@Composable
fun Avatar(
    link: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = DodamTheme.color.Background,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
    placeHolderBaseColor: Color = DodamTheme.color.White,
    placeHolderHighlightColor: Color = DodamTheme.color.MainColor100,
    failureIconSize: Dp = 20.dp,
    failureIconColor: Color = DodamTheme.color.Gray400,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, backgroundColor)
            .dodamClickable(
                onClick = onClick,
                rippleColor = rippleColor,
                rippleEnable = rippleEnable,
                bounded = bounded
            ),
        contentAlignment = Alignment.Center,
    ) {
        GlideImage(
            modifier = Modifier
                .fillMaxSize(),
            imageModel = { link },
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
                IcUser(
                    modifier = modifier
                        .size(failureIconSize)
                        .align(Alignment.Center),
                    tint = failureIconColor,
                    contentDescription = null,
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AvatarPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Avatar(name = "최민재")
        Spacer(modifier = Modifier.height(10.dp))
        Avatar(painter = painterResource(id = R.drawable.img_dummy))
        Spacer(modifier = Modifier.height(10.dp))
        Avatar(iconColor = DodamColor.FeatureColor.MyInfoColor)
        Avatar(iconColor = DodamColor.FeatureColor.MyInfoColor, size = 100.dp, iconSize = 50.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Avatar(link = "https://i.ytimg.com/vi/zbyet4HK4ko/maxresdefault.jpg", size = 100.dp)
    }
}
