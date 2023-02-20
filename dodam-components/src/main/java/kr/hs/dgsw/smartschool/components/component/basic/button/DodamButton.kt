package kr.hs.dgsw.smartschool.components.component.basic.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcDinner3D
import kr.hs.dgsw.smartschool.components.theme.IcHome
import kr.hs.dgsw.smartschool.components.theme.Label1
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

/**
 * Dodam small rounded button, 5.dp
 *
 * @param text content in button
 * @param modifier modifier
 * @param iconLeft left icon
 * @param iconRight right icon
 * @param type button type, define color
 * @param enable button enable state
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click button
 */
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

/**
 * Dodam medium rounded button, 10.dp
 *
 * @param text content in button
 * @param modifier modifier
 * @param iconLeft left icon
 * @param iconRight right icon
 * @param type button type, define color
 * @param enable button enable state
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click button
 */
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

/**
 * Dodam large rounded button, 20.dp
 *
 * @param text content in button
 * @param modifier modifier
 * @param iconLeft left icon
 * @param iconRight right icon
 * @param type button type, define color
 * @param enable button enable state
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param onClick when click button
 */
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

/**
* Dodam max width size button, 20.dp
*
* @param text content in button
* @param modifier modifier
* @param shape button shape
* @param type button type, define color
* @param enable button enable state
* @param rippleColor rippleColor
* @param rippleEnable rippleEnable
* @param bounded bounded
* @param onClick when click button
*/
@Composable
fun DodamMaxWidthButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = DodamTheme.shape.medium,
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
        iconLeft = null,
        iconRight = null,
        shape = shape,
        type = type,
        enable = enable,
        rippleColor = rippleColor,
        rippleEnable = rippleEnable,
        bounded = bounded
    ) {
        Label1(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PreviewDodamButton() {
    Column(
        modifier = Modifier.padding(DodamDimen.ScreenSidePadding),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        DodamLargeRoundedButton(
            onClick = {},
            iconLeft = { IcHome(contentDescription = null) },
            iconRight = { IcDinner3D(contentDescription = null) },
            text = "도담도담!"
        )
        DodamMediumRoundedButton(onClick = {}, text = "도담", iconLeft = { IcHome(contentDescription = null) })
        DodamSmallRoundedButton(onClick = {}, text = "Button", modifier = Modifier.width(150.dp))
        DodamMaxWidthButton(text = "로그인") {
        }
    }
}

@Preview
@Composable
private fun PreviewDodamRadioButton() {
    Column(
        modifier = Modifier
            .padding(DodamDimen.ScreenSidePadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        var radioSelect by remember { mutableStateOf(0) }
        DodamRadioButton(selected = radioSelect == 0) {
            radioSelect = 0
        }
        DodamRadioButton(selected = radioSelect == 1) {
            radioSelect = 1
        }
        DodamRadioButton(selected = radioSelect == 2) {
            radioSelect = 2
        }
        DodamRadioButton(selected = radioSelect == 3) {
            radioSelect = 3
        }
    }
}
