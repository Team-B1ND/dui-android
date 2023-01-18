package kr.hs.dgsw.smartschool.components.component.input

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow

@Composable
fun Select(
    itemList: List<String>,
    hint: String,
    enabled: Boolean = true,
    focusColor: Color = DodamColor.MainColor400,
    isError: Boolean = false,
    errorMessage: String = "",
    textColor: Color = DodamColor.Black,
    textStyle: TextStyle = DodamTheme.typography.body2,
    readOnly: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = false,
    bounded: Boolean = true,
    onItemSelectedListener: (String) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Input(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            hint = hint,
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
                .focusRequester(focusRequester),
            enabled = enabled,
            focusColor = focusColor,
            isError = isError,
            errorMessage = errorMessage,
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
                        onItemSelectedListener(selectedItem)
                        expanded = false
                    }) {
                        Body3(
                            text = label,
                            textColor =
                            if (selectedItem == label)
                                if (isError)
                                    DodamColor.Error
                                else
                                    focusColor
                            else
                                DodamColor.Black
                        )
                    }

                    if (index != itemList.size - 1)
                        Divider(color = DodamColor.Gray50)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            val sampleList = listOf("Hello", "Kotlin", "Python", "Dark", "Go")
            Select(itemList = sampleList, "선택해 주세요.", enabled = false)
            Select(itemList = sampleList, "선택2", focusColor = DodamColor.FeatureColor.ItMapColor) { selectedItem ->
                Log.d("TestDropDown", "SelectedItem : $selectedItem")
            }
        }
    }
}

