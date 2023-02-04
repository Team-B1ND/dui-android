package kr.hs.dgsw.smartschool.dui

import kr.hs.smartschool.components.R

object DataSet {

    val ITEM_TEST: Item =
        Item(R.drawable.ic_info_3d, "Test", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "test")

    val LIST_MAIN: List<Item> = listOf(
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_palette_3d, "Color", "도담도담은 어떤 색을 사용할까?", "color"),
        Item(R.drawable.ic_info_3d, "Typo", "테스트를 위한 이런 데이터도 괜찮지 않을까요..?", "typo"),
        Item(R.drawable.ic_info_3d, "Icon", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "icon"),
        Item(R.drawable.ic_info_3d, "Shape", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "shape"),
        Item(R.drawable.ic_info_3d, "Button", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "button"),
        Item(R.drawable.ic_info_3d, "Input", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "Input"),
        Item(R.drawable.ic_info_3d, "Button", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "button"),
        Item(R.drawable.ic_info_3d, "Chip", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "chip"),
        Item(R.drawable.ic_info_3d, "ETC", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "etc")
    )
}

object Text {
    const val DUI_TITLE = "DUI Preview"
    const val DUI_DESCRIPTION = "도담 디자인 시스템"
}

data class Item(
    val icon: Int,
    val title: String,
    val content: String,
    val route: String
)
