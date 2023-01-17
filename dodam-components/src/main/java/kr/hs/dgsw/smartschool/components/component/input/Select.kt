package kr.hs.dgsw.smartschool.components.component.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.theme.Body1
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow

sealed interface SelectType {
    object Default : SelectType
    object UnFocus : SelectType
    object Focus : SelectType
    object Error {
        object Default : SelectType
        object UnFocus : SelectType
        object Focus : SelectType
    }
}

private data class SelectItem(
    val value: String,
    val isSelected: Boolean
)

@Composable
fun Select(
    items: List<String>,
    modifier: Modifier = Modifier,
    hint: String = "",
    inSelectionMode: Boolean = false,
    focusColor: Color = DodamColor.MainColor,
    isError: Boolean = false,
    selectType: SelectType = SelectType.Default,
) {
    val selectItems = emptyList<SelectItem>().toMutableList()
    items.forEach { 
        selectItems.add(SelectItem(it, false))
    }

    val selectColor = if (isError) DodamColor.Error else focusColor

    Column {
        Input(
            value = getSelectedItem(selectItems),
            onValueChange = {},
            hint = hint,
            modifier = modifier,
            isError = isError,
            trailingIcon = {
                if (inSelectionMode)
                    IcLeftArrow(
                        contentDescription = null,
                        modifier = Modifier.rotate(90f)
                    )
                else
                    IcLeftArrow(
                        contentDescription = null,
                        modifier = Modifier.rotate(270f)
                    )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        SelectItemsBox(selectItems, if (isError) DodamColor.Error else selectColor)
    }
}

@Composable
private fun SelectItemsBox(
    selectItems: List<SelectItem>,
    selectedColor: Color,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .wrapContentSize(unbounded = true)
            .verticalScroll(rememberScrollState()),
        reverseLayout = true
    ) {

        items(selectItems) {
            SelectItem(it, selectedColor)
            Divider(color = DodamColor.Gray100)
        }
    }
}

@Composable
private fun SelectItem(
    selectItem: SelectItem,
    selectedColor: Color
) {
    val textColor = if (selectItem.isSelected) selectedColor else DodamColor.Black
    Body3(
        text = selectItem.value,
        textColor = textColor,
        modifier = Modifier
            .padding(10.dp)
    )
}

private fun getSelectedItem(selectItems: List<SelectItem>): String {
    var selectedItem = ""
    selectItems.forEach {
        if (it.isSelected)
            selectedItem = it.value
    }
    return selectedItem
}