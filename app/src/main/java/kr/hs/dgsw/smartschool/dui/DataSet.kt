package kr.hs.dgsw.smartschool.dui

import kr.hs.smartschool.components.R

object DataSet {

    val ITEM_TEST: Item =
        Item(R.drawable.ic_info_3d, "Test", "테스트를 위한 이런 데이터도 괜찮지 않을까요?", "test")

    val LIST_MAIN: List<Item> = listOf(
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_palette_3d, "Color", "도담도담은 사용하는 색상 모임입니다", "color"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_pencil_3d, "Typo", "도담도담에서 사용하는 Typography", "typo"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_star_3d, "Icon", "도담도담의 각 Feature에서 사용하는 Icon", "icon"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_shape_3d, "Shape", "기본적인 Shape들을 담고 있습니다", "shape"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_button_3d, "Button", "도담도담의 다양한 버튼을 살펴보세요", "button"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_input_3d, "Input", "정보를 입력받는 Input입니다", "Input"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_select_3d, "Select", "입력 및 선택이 가능한 Select입니다", "select"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_tab_3d, "Tab", "주로 전환에 사용되는 Tab입니다", "tab"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_avatar_3d, "Avatar", "사용자의 Profile을 나타냅니다", "avatar"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_card_3d, "Card", "View 구성에 꼭 필요한 Card 디자인입니다", "card"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_banner_3d, "Banner", "도담도담은 배너를 이런 식으로 구성한다!", "banner"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_bottom_sheet_3d, "Bottom Sheet", "아래에서 올라오는 BottomSheet입니다", "bottomSheet"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_calendar_3d, "Calender", "도담도담이 일정을 보여줄 때 꼭 필요한..", "calender"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_app_bar_3d, "App Bar", "편리하고 깔끔한 AppBar", "appBar"),
        Item(kr.hs.dgsw.smartschool.dui.R.drawable.ic_check_3d, "Toggle", "CheckBox, Switch를 한데 모은 Toggle입니다", "toggle"),
    )

    object Text {
        const val TITLE_DUI = "DUI Preview"
        const val DESCRIPTION_DUI = "도담 디자인 시스템"

        const val TITLE_APP_BAR = "App Bar"
        const val TITLE_AVATAR = "Avatar"
        const val TITLE_BANNER = "Banner"
        const val TITLE_BOTTOM_SHEET = "Bottom Sheet"
        const val TITLE_BUTTON = "Button"
        const val TITLE_CALENDER = "Calender"
        const val TITLE_CARD = "Card"
        const val TITLE_TOGGLE = "Toggle"
        const val TITLE_COLOR = "Color"
        const val TITLE_ICON = "Icon"
        const val TITLE_INPUT = "Input"
        const val TITLE_SELECT = "Select"
        const val TITLE_SHAPE = "Shape"
        const val TITLE_TAB = "Tab"
        const val TITLE_TYPO = "Typo"

        const val TEXT_HINT = "값을 입력해주세요"
        const val TEXT_MEAL = "*기장밥, 김치어묵국, *명태껍질볶음, 새송이돈육마늘구이, *짜먹는요거트, *꽃상추쌈/쌈장"
    }

    data class Item(
        val icon: Int,
        val title: String,
        val content: String,
        val route: String
    )
}
