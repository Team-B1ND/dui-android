package kr.hs.dgsw.smartschool.components.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcDinner3D
import kr.hs.dgsw.smartschool.components.theme.IcOut3D
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

@Composable
fun ItemCard(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    titleStyle: TextStyle = DodamTheme.typography.label1,
    subTitleStyle: TextStyle = DodamTheme.typography.body3,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {
    Surface(
        onClick = if (enable) onClick else null,
        modifier = modifier.width(120.dp),
        shape = shape,
        color = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 18.dp,
                    vertical = 18.dp
                )
                .fillMaxWidth(),
        ) {
            Text(text = subTitle, style = subTitleStyle.copy(color = DodamTheme.color.Gray500))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, style = titleStyle.copy(color = contentColorFor(backgroundColor = background)))
            icon?.let {
                Spacer(modifier = Modifier.height(14.dp))
                Box(modifier = modifier.align(Alignment.End)) {
                    it()
                }
            }
        }
    }
}

@Composable
fun ContentCard(
    title: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    hasLinkIcon: Boolean = false,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    titleStyle: TextStyle = DodamTheme.typography.title2,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: (@Composable () -> Unit)? = null
) {
    Surface(
        onClick = if (enable) onClick else null,
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        color = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 18.dp,
                    vertical = 18.dp
                )
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    text = title,
                    style = titleStyle.copy(
                        color = contentColorFor(backgroundColor = background),
                        fontSize = 18.sp,
                        lineHeight = 28.sp,
                    ),
                    modifier = Modifier.weight(1f)
                )
                if (hasLinkIcon) {
                    Spacer(modifier = Modifier.height(14.dp))
                    IcRightArrow(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.CenterVertically),
                        tint = DodamTheme.color.Gray400,
                        contentDescription = null
                    )
                }
            }
            content?.let {
                Spacer(modifier = Modifier.height(18.dp))
                it()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCard() {
    Column {
        Row {
            ItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
            )

            Spacer(modifier = Modifier.width(10.dp))

            ItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
                icon = { IcOut3D(contentDescription = null) }
            )

            Spacer(modifier = Modifier.width(10.dp))

            ItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
                icon = { IcOut3D(contentDescription = null) },
                onClick = {}
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        ContentCard(title = "오늘의 석식")

        Spacer(modifier = Modifier.height(10.dp))
        ContentCard(title = "오늘의 석식", hasLinkIcon = true)

        Spacer(modifier = Modifier.height(10.dp))
        ContentCard(title = "오늘의 석식", hasLinkIcon = true) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IcDinner3D(contentDescription = null, modifier = Modifier.size(32.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Body3(text = "오늘은 급식이 없네요!", modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }

}