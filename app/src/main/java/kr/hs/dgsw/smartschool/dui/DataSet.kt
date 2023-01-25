package kr.hs.dgsw.smartschool.dui

import kr.hs.dgsw.smartschool.dui.screen.Item
import kr.hs.smartschool.components.R

object DataSet {

    val ITEM_TEST : Item =
        Item(R.drawable.ic_info_3d, "Test", "테스트를 위한 이런 데이터도 괜찮지 않을까요?")

    val LIST_MAIN : List<Item> = listOf(
        Item(R.drawable.ic_document_3d, "Color", "도담도담은 어떤 색을 사용할까?"),
        Item(R.drawable.ic_info_3d, "Typo", "테스트를 위한 이런 데이터도 괜찮지 않을까요..?"),
        Item(R.drawable.ic_info_3d, "Icon", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "Radius", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "Bar", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "Badge", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "Button", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "Chip", "테스트를 위한 이런 데이터도 괜찮지 않을까요?"),
        Item(R.drawable.ic_info_3d, "ETC", "테스트를 위한 이런 데이터도 괜찮지 않을까요?")
    )
}

object Text{
    const val DUI_TITLE = "DUI Preview"
    const val DUI_DESCRIPTION = "도담 디자인 시스템"
}