package kr.hs.dgsw.smartschool.components.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

@Composable
fun DodamSmallRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = DodamTheme.shape.small,
        type = type,
        enable = enable,
        rippleColor = rippleColor,
        rippleEnable = rippleEnable,
        bounded = bounded
    ) {
        Label1(text = text)
    }
}

@Composable
fun DodamMediumRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        type = type,
        enable = enable,
        rippleColor = rippleColor,
        rippleEnable = rippleEnable,
        bounded = bounded
    ) {
        Label1(text = text)
    }
}

@Composable
fun DodamLargeRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = DodamTheme.shape.large,
        type = type,
        enable = enable,
        rippleColor = rippleColor,
        rippleEnable = rippleEnable,
        bounded = bounded
    ) {
        Label1(text = text)
    }
}

@Preview
@Composable
private fun PreviewDodamButton() {
    Column(
        modifier = Modifier.padding(DodamDimen.ScreenSidePadding)
    ) {
        DodamLargeRoundedButton(onClick = {}, text = "도담도담!")
        Spacer(modifier = Modifier.height(10.dp))
        DodamMediumRoundedButton(onClick = {}, text = "도담")
        Spacer(modifier = Modifier.height(10.dp))
        DodamSmallRoundedButton(onClick = {}, text = "Button")
    }
}
