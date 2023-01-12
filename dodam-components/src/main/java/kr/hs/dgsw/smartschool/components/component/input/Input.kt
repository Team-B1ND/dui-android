package kr.hs.dgsw.smartschool.components.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

sealed interface InputType {
    object Default : InputType
    object UnFocus : InputType
    object Focus : InputType
    object Error : InputType
}

private val MinHeight = 60.dp
private val MinWidth = 80.dp

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textColor: Color = Color.Black,
    textStyle: TextStyle = DodamTheme.typography.body2,
    inputType: InputType = InputType.Default,
    focusColor: Color = DodamTheme.color.MainColor400,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var currentInputType by remember { mutableStateOf(inputType) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(
                color = DodamTheme.color.Transparent,
                shape = RectangleShape
            )
            .defaultMinSize(
                minWidth = MinWidth,
                minHeight = MinHeight,
            )
            .focusRequester(focusRequester)
            .onFocusChanged {
                currentInputType = focusStateAsInputType(it.isFocused, value)
            },
        enabled = enabled,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(Color.Black),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        maxLines = 1,
        decorationBox = @Composable { innerTextField ->
            InputDecoration(
                inputType = currentInputType,
                hint = hint,
                innerTextField = innerTextField,
                focusColor = focusColor,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
            )
        }
    )
}

@Composable
fun InputDecoration(
    inputType: InputType,
    hint: String,
    focusColor: Color,
    innerTextField: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    val inputColor = when (inputType) {
        InputType.Default -> DodamTheme.color.Gray200
        InputType.UnFocus -> DodamTheme.color.Black
        InputType.Focus -> focusColor
        InputType.Error -> DodamTheme.color.Error
    }

    Column(

    ) {
        if (inputType != InputType.Default)
            Body3(
                text = hint,
                textColor = inputColor
            )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = inputColor,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                },
        ) {
            Row(
                modifier = Modifier.padding(
                    vertical = 12.dp,
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingIcon?.let {
                    leadingIcon()
                    Spacer(modifier = Modifier.width(7.dp))
                }

                if (inputType == InputType.Default)
                    Body2(text = hint, textColor = inputColor)
                else
                    innerTextField()

                trailingIcon?.let {
                    Spacer(modifier = Modifier.width(7.dp))
                    trailingIcon()
                }
            }
        }
    }
}

private fun focusStateAsInputType(isFocused: Boolean, currentValue: String): InputType =
    if (isFocused) {
        InputType.Focus
    } else if (currentValue.isNotBlank()) {
        InputType.UnFocus
    } else if (currentValue.isBlank()) {
        InputType.Default
    } else {
        InputType.Default
    }

