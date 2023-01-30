package kr.hs.dgsw.smartschool.components.component.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcUser
import kr.hs.smartschool.components.R

@Composable
fun Avatar(
    painter: Painter,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
) {
    Box(
        modifier = modifier
            .size(size)
    ) {
        Image(
            modifier = Modifier
                .clip(shape)
                .fillMaxSize(),
            painter = painter,
            contentDescription = null
        )
    }
}

@Composable
fun Avatar(
    name: String,
    modifier: Modifier = Modifier,
    nameStyle: TextStyle = DodamTheme.typography.title2,
    nameColor: Color = DodamTheme.color.Gray400,
    backgroundColor: Color = DodamTheme.color.Background,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name.take(1),
            style = nameStyle,
            color = nameColor,
        )
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    iconSize: Dp = 20.dp,
    iconColor: Color = DodamTheme.color.Gray400,
    backgroundColor: Color = DodamTheme.color.Background,
    shape: Shape = CircleShape,
    size: Dp = 40.dp,
) {
    Box(
        modifier = modifier
            .size(size)
            .surface(shape, backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        IcUser(
            modifier = modifier.size(iconSize),
            tint = iconColor,
            contentDescription = null,
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
    }
}
