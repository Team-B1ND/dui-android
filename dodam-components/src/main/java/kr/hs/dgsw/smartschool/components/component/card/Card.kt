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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcOut3D

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
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 18.dp
            ).fillMaxWidth(),
        ) {
            Text(text = subTitle, style = subTitleStyle.copy(color = DodamTheme.color.Gray500))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, style = titleStyle.copy(color = DodamTheme.color.Black))
            icon?.let {
                Spacer(modifier = Modifier.height(14.dp))
                Box(modifier = modifier.align(Alignment.End)) {
                    icon()
                }
            }
        }
    }
}

@Composable
fun ContentCard(

) {

}

@Preview(showBackground = true)
@Composable
private fun PreviewItemCard() {
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
}