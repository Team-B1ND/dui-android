package kr.hs.dgsw.smartschool.components.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.LocalContentColor

sealed interface InputType {
    object Default : InputType
    object UnFocus : InputType
    object Focus : InputType
    object Error {
        object Default : InputType
        object UnFocus : InputType
        object Focus : InputType
    }
}

private val MinHeight = 60.dp
private val MinWidth = 80.dp

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String = "",
    enabled: Boolean = true,
    textColor: Color = Color.Black,
    textStyle: TextStyle = DodamTheme.typography.body2,
    focusColor: Color = DodamTheme.color.MainColor400,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var currentInputType: InputType by remember { mutableStateOf(InputType.Default) }

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
                currentInputType = focusStateAsInputType(it.isFocused, value, isError)
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
                errorMessage = errorMessage,
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
    errorMessage: String,
    innerTextField: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    val inputColor = when (inputType) {
        InputType.Default -> DodamTheme.color.Gray200
        InputType.UnFocus -> DodamTheme.color.Black
        InputType.Focus -> focusColor
        InputType.Error.Default -> DodamTheme.color.Error
        InputType.Error.Focus -> DodamTheme.color.Error
        InputType.Error.UnFocus -> DodamTheme.color.Error
    }

    Column {
        // Label
        if (!(inputType == InputType.Default || inputType == InputType.Error.Default))
            Body3(text = hint, textColor = inputColor)

        MainTextField(
            hint = hint,
            inputColor = inputColor,
            inputType = inputType,
            innerTextField = innerTextField,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )

        // Bottom Label -> error message
        if (
            (inputType == InputType.Error.Default) or
            (inputType == InputType.Error.UnFocus) or
            (inputType == InputType.Error.Focus)
        ) {
            Spacer(modifier = Modifier.height(3.dp))
            Body3(text = errorMessage, textColor = inputColor)
        }
    }
}

@Composable
private fun MainTextField(
    hint: String,
    inputColor: Color,
    inputType: InputType,
    innerTextField: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
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
                CompositionLocalProvider(
                    LocalContentColor provides inputColor
                ) {
                    leadingIcon()
                }
                Spacer(modifier = Modifier.width(7.dp))
            }

            if (inputType == InputType.Default || inputType == InputType.Error.Default)
                Body2(text = hint, textColor = inputColor, modifier = Modifier.weight(1f))
            else
                Box(Modifier.weight(1f)) {
                    innerTextField()
                }
            trailingIcon?.let {
                Spacer(modifier = Modifier.width(7.dp))
                CompositionLocalProvider(
                    LocalContentColor provides inputColor
                ) {
                    trailingIcon()
                }
            }
        }
    }
}

private fun focusStateAsInputType(
    isFocused: Boolean,
    currentValue: String,
    isError: Boolean
): InputType =
    if (isError) {
        if (isFocused) {
            InputType.Error.Focus
        } else if (currentValue.isNotBlank()) {
            InputType.Error.UnFocus
        } else if (currentValue.isBlank()) {
            InputType.Error.Default
        } else {
            InputType.Error.Default
        }
    } else if (isFocused) {
        InputType.Focus
    } else if (currentValue.isNotBlank()) {
        InputType.UnFocus
    } else if (currentValue.isBlank()) {
        InputType.Default
    } else {
        InputType.Default
    }

