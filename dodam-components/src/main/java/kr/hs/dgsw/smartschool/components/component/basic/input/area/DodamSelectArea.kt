package kr.hs.dgsw.smartschool.components.component.basic.input.area

import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow

sealed interface SelectAreaType {
    object Default : SelectAreaType
    object Focus : SelectAreaType
    object UnFocus : SelectAreaType
    object Error : SelectAreaType
}

/**
 * Dodam Select Area, can select item in area
 *
 * @param itemList list of item, select in here!
 * @param hint select guide
 * @param modifier
 * @param onValueChange when value change callback
 * @param focusColor color when focus to this input area
 * @param enabled input area enabled state
 * @param topLabel label, top
 * @param bottomLabel label, bottom
 * @param isError error state, write condition!
 * @param textColor color of text
 * @param textStyle style of text
 * @param readOnly just read?
 * @param rippleColor
 * @param rippleEnable
 * @param bounded
 * @param onItemClickListener when click item callback(item name)
 */
@Composable
fun DodamSelectArea(
    itemList: List<String>,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    focusColor: Color = DodamColor.MainColor400,
    enabled: Boolean = true,
    topLabel: String = "",
    bottomLabel: String = "",
    isError: Boolean = false,
    textColor: Color = DodamColor.Black,
    textStyle: TextStyle = DodamTheme.typography.body2,
    readOnly: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = false,
    bounded: Boolean = true,
    onItemClickListener: (String) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val focusRequester = remember { FocusRequester() }

    Column {
        SelectInputArea(
            value = selectedItem,
            onValueChange = {
                selectedItem = it
                onValueChange(it)
            },
            hint = hint,
            modifier = modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .focusRequester(focusRequester),
            enabled = enabled,
            focusColor = if (isError) DodamTheme.color.Error else focusColor,
            isError = isError,
            topLabel = topLabel,
            bottomLabel = bottomLabel,
            textColor = textColor,
            textStyle = textStyle,
            readOnly = readOnly,
            trailingIcon = {
                IcLeftArrow(
                    modifier = Modifier
                        .dodamClickable(
                            rippleColor = rippleColor,
                            rippleEnable = rippleEnable,
                            bounded = bounded
                        ) {
                            if (enabled) {
                                expanded = !expanded
                                focusRequester.requestFocus()
                            }
                        }
                        .rotate(if (expanded) 90f else 270f)
                        .size(15.dp),
                    contentDescription = null
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(
                    with(LocalDensity.current) {
                        textFieldSize.width.toDp()
                    }
                ),
        ) {
            itemList.forEachIndexed { index, label ->
                Column {
                    DropdownMenuItem(onClick = {
                        selectedItem = label
                        expanded = false
                        onItemClickListener(label)
                    }) {
                        Body3(
                            text = label,
                            textColor =
                            if (selectedItem == label)
                                if (isError)
                                    DodamTheme.color.Error
                                else
                                    focusColor
                            else
                                DodamTheme.color.Black
                        )
                    }

                    if (index != itemList.size - 1)
                        Divider(color = DodamTheme.color.Gray50)
                }
            }
        }
    }
}

@Composable
private fun SelectInputArea(
    value: String,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable () -> Unit,
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

    var currentSelectAreaType: SelectAreaType by remember { mutableStateOf(SelectAreaType.Default) }

    Column {
        if (topLabel.isNotBlank())
            Body3(
                text = topLabel,
                textColor = getSelectAreaColorByType(
                    selectAreaType = currentSelectAreaType,
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
                    currentSelectAreaType = stateAsSelectAreaType(it.isFocused, value, isError)
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
                SelectAreaDecoration(
                    selectAreaType = currentSelectAreaType,
                    trailingIcon = trailingIcon,
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
                textColor = getSelectAreaColorByType(
                    selectAreaType = currentSelectAreaType,
                    focusColor = focusColor,
                )
            )
    }
}

@Composable
fun SelectAreaDecoration(
    selectAreaType: SelectAreaType,
    trailingIcon: @Composable () -> Unit,
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

            if (selectAreaType is SelectAreaType.Default)
                Body2(
                    text = hint,
                    textColor = DodamTheme.color.Gray200,
                    modifier = Modifier.weight(1f)
                )
            else
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField()
                }

            Box(modifier = Modifier.padding(start = 12.dp)) {
                trailingIcon()
            }
        }
    }
}

private fun stateAsSelectAreaType(
    isFocused: Boolean,
    currentValue: String,
    isError: Boolean,
): SelectAreaType =
    if (isError) {
        SelectAreaType.Error
    } else if (isFocused) {
        SelectAreaType.Focus
    } else if (currentValue.isBlank()) {
        SelectAreaType.Default
    } else {
        SelectAreaType.UnFocus
    }

@Composable
private fun getSelectAreaColorByType(
    selectAreaType: SelectAreaType,
    focusColor: Color,
    isLabel: Boolean = true,
): Color =
    when (selectAreaType) {
        SelectAreaType.Default -> if (isLabel) DodamTheme.color.Black else DodamTheme.color.Gray200
        SelectAreaType.UnFocus -> DodamTheme.color.Black
        SelectAreaType.Focus -> focusColor
        SelectAreaType.Error -> DodamTheme.color.Error
    }

@Preview(showBackground = true)
@Composable
fun SelectAreaPreview() {
    val sampleList = listOf("Hello", "Hello2", "Hello3", "Hello4")
    val context = LocalContext.current

    Column(
        Modifier
            .background(color = DodamColor.Background)
            .padding(20.dp)
            .fillMaxSize()
    ) {
        DodamSelectArea(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            hint = "Hello World",
            bottomLabel = "Heete"
        )

        Spacer(modifier = Modifier.height(10.dp))

        val isError = remember { mutableStateOf(false) }
        DodamSelectArea(
            itemList = sampleList,
            topLabel = "TestTest",
            onItemClickListener = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                isError.value = it == "Hello2"
            },
            hint = "Input Some Text",
            isError = isError.value,
        )

        Spacer(modifier = Modifier.height(10.dp))

        DodamSelectArea(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = false,
            hint = "사이즈 조정 가능",
            focusColor = DodamColor.FeatureColor.ItMapColor,
        )
    }
}
