package kr.hs.dgsw.smartschool.components.component.basic.input

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
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
import androidx.compose.ui.platform.LocalContext
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

/**
 * Dodam Select, can select item
 *
 * @param itemList list of item, select in here!
 * @param hint select guide
 * @param modifier
 * @param onValueChange when value change callback
 * @param focusColor color when focus to this input area
 * @param enabled input area enabled state
 * @param isError error state, write condition!
 * @param errorMessage message to guide error, placed bottom
 * @param textColor color of text
 * @param textStyle style of text
 * @param readOnly just read?
 * @param rippleColor
 * @param rippleEnable
 * @param bounded
 * @param onItemClickListener when click item callback(item name)
 */
@Composable
fun DodamSelect(
    itemList: List<String>,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    focusColor: Color = DodamColor.MainColor400,
    enabled: Boolean = true,
    isError: Boolean = false,
    errorMessage: String = "",
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
        DodamInput(
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
            enabled = readOnly.not(),
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
                        expanded = false
                        onItemClickListener(label)
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
    val sampleList = listOf("Hello", "Hello2", "Hello3", "Hello4")
    val context = LocalContext.current

    Column(
        Modifier
            .background(color = DodamColor.Background)
            .padding(20.dp)
            .fillMaxSize()
    ) {
        DodamSelect(
            itemList = sampleList,
            onItemClickListener = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() },
            hint = "Hello World",
        )

        Spacer(modifier = Modifier.height(20.dp))

        val isError = remember { mutableStateOf(false) }
        DodamSelect(
            itemList = sampleList,
            onItemClickListener = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                isError.value = it == "Hello2"
            },
            hint = "Input Some Text",
            isError = isError.value,
            errorMessage = if (isError.value) "Error Message" else ""
        )

        Spacer(modifier = Modifier.height(20.dp))

        DodamSelect(
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
