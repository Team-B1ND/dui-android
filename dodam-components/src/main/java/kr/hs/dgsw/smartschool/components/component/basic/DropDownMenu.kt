package kr.hs.dgsw.smartschool.components.component.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow

@Composable
fun DropDownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Kotlin", "Java", "Dart", "Python")
    var selectedItem by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Input(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            hint = "Selected Item",
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            trailingIcon = {
                IcLeftArrow(
                    modifier = Modifier
                        .rotate(if (expanded) 90f else 270f)
                        .clickable { expanded = !expanded }
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
                )
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    Body3(text = label)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownMenuPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            DropDownMenu()
            DropDownMenu()
        }

    }
}

