package kr.hs.dgsw.smartschool.components.component.calendar

import androidx.compose.ui.graphics.Color

sealed class DodamBasicCategories(val color: Color, val name: String) {

    class FirstGrade(
        color: Color = Color(0x70F0AC3C),
        name: String = "1학년",
    ): DodamBasicCategories(color, name)

    class SecondGrade(
        color: Color = Color(0x7064BAE1),
        name: String = "2학년",
    ): DodamBasicCategories(color, name)

    class ThirdGrade(
        color: Color = Color(0x709856DA),
        name: String = "3학년",
    ): DodamBasicCategories(color, name)

    class AllGrade(
        color: Color = Color(0x70F09771),
        name: String = "전학년",
    ): DodamBasicCategories(color, name)

    class Others(
        color: Color = Color(0x700067BC),
        name: String = "기타",
    ): DodamBasicCategories(color, name)
}
