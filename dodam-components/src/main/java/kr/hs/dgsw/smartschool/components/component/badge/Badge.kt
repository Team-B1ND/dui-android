package kr.hs.dgsw.smartschool.components.component.badge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Surface
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.contentColorFor

@Composable
fun Badge(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    background: Color = DodamTheme.color.MainColor,
    textColor: Color = contentColorFor(backgroundColor = background),
    textStyle: TextStyle = DodamTheme.typography.label2,
    shape: Shape = DodamTheme.shape.large,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewBadge() {
    Column(Modifier.padding(20.dp)) {
        Badge(text = "도담도담", onClick = {})
    }
}
