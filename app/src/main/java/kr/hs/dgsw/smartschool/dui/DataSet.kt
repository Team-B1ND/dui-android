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
        Item(R.drawable.ic_info_3d, "Select", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "select"),
        Item(R.drawable.ic_info_3d, "Tab", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "tab"),
        Item(R.drawable.ic_info_3d, "Avatar", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "avatar"),
        Item(R.drawable.ic_info_3d, "Banner", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "banner"),
        Item(R.drawable.ic_info_3d, "Bottom Sheet", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "bottomSheet"),
        Item(R.drawable.ic_info_3d, "Calender", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "calender"),
        Item(R.drawable.ic_info_3d, "App Bar", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "appBar"),
        Item(R.drawable.ic_info_3d, "Check Box", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "checkBox"),
        Item(R.drawable.ic_info_3d, "Switch", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "switch"),


        )

    object Text {
        const val DUI_TITLE = "DUI Preview"
        const val DUI_DESCRIPTION = "도담 디자인 시스템"

        const val TEXT_HINT = "값을 입력해주세요"
    }

    data class Item(
        val icon: Int,
        val title: String,
        val content: String,
        val route: String
    )
}
