package kr.hs.dgsw.smartschool.components.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

sealed interface InputAreaType {
    object Default : InputAreaType
    object Focus : InputAreaType
    object UnFocus : InputAreaType
    object Error : InputAreaType
}

@Composable
fun InputArea(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    isError: Boolean = false,
    topLabel: String = "",
    bottomLabel: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    textColor: Color = Color.Black,
    textStyle: TextStyle = DodamTheme.typography.body2,
    focusColor: Color = DodamTheme.color.MainColor400,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var currentInputType: InputAreaType by remember { mutableStateOf(InputAreaType.Default) }

    Column {
        if (topLabel.isNotBlank())
            Body3(
                text = topLabel,
                textColor = getInputAreaColorByType(
                    inputAreaType = currentInputType,
                    focusColor = focusColor,
                )
            )
        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .width(IntrinsicSize.Max)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    currentInputType = stateAsInputAreaType(it.isFocused, value, isError)
                },
            enabled = enabled,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(focusColor),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            readOnly = readOnly,
            decorationBox = @Composable { innerTextField ->
                InputAreaDecoration(
                    inputAreaType = currentInputType,
                    hint = hint,
                    innerTextField = innerTextField,
                )
            }
        )

        Spacer(modifier = Modifier.height(4.dp))
        // Bottom Label
        if (bottomLabel.isNotBlank())
            Body3(
                text = bottomLabel,
                textColor = getInputAreaColorByType(
                    inputAreaType = currentInputType,
                    focusColor = focusColor,
                )
            )
    }
}

@Composable
fun InputAreaDecoration(
    inputAreaType: InputAreaType,
    hint: String,
    innerTextField: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(
                color = DodamTheme.color.White,
                shape = DodamTheme.shape.medium
            )
            .padding(12.dp),
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (inputAreaType is InputAreaType.Default)
                Body2(text = hint, textColor = DodamTheme.color.Gray200)
            else
                innerTextField()
        }
    }
}

private fun stateAsInputAreaType(
    isFocused: Boolean,
    currentValue: String,
    isError: Boolean,
): InputAreaType =
    if (isError) {
        InputAreaType.Error
    } else if (isFocused) {
        InputAreaType.Focus
    } else if (currentValue.isBlank()) {
        InputAreaType.Default
    } else {
        InputAreaType.UnFocus
    }

@Composable
private fun getInputAreaColorByType(
    inputAreaType: InputAreaType,
    focusColor: Color,
    isLabel: Boolean = true,
): Color =
    when (inputAreaType) {
        InputAreaType.Default -> if (isLabel) DodamTheme.color.Black else DodamTheme.color.Gray200
        InputAreaType.UnFocus -> DodamTheme.color.Black
        InputAreaType.Focus -> focusColor
        InputAreaType.Error -> DodamTheme.color.Error
    }

@Preview(showBackground = true)
@Composable
fun InputAreaPreview() {
    var testValue by remember { mutableStateOf("") }
    var testValue2 by remember { mutableStateOf("") }
    var testValue3 by remember { mutableStateOf("") }

    Column(
        Modifier
            .background(color = DodamColor.Background)
            .padding(20.dp)
            .fillMaxSize()
    ) {
        InputArea(
            value = testValue,
            onValueChange = { testValue = it },
            hint = "Hello World",
        )

        Spacer(modifier = Modifier.height(10.dp))

        InputArea(
            value = testValue2,
            onValueChange = { testValue2 = it },
            topLabel = "Top Label",
            hint = "Input Some Text"
        )

        Spacer(modifier = Modifier.height(10.dp))

        InputArea(
            value = testValue3,
            onValueChange = { testValue3 = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
            topLabel = "Top Label",
            bottomLabel = "Bottom Label",
            hint = "사이즈 조정 가능",
            focusColor = DodamColor.FeatureColor.ItMapColor,
        )
    }
}
