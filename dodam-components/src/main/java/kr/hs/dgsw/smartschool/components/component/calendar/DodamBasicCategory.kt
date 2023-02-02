package kr.hs.dgsw.smartschool.components.component.calendar

import androidx.compose.ui.graphics.Color

val dodamBasicCategories = listOf(
    DodamBasicCategory.FirstGrade(),
    DodamBasicCategory.SecondGrade(),
    DodamBasicCategory.ThirdGrade(),
    DodamBasicCategory.AllGrade(),
    DodamBasicCategory.Others(),
)

sealed class DodamBasicCategory(val color: Color, val name: String) {

    class FirstGrade(
        color: Color = Color(0x70F0AC3C),
        name: String = "1학년",
    ): DodamBasicCategory(color, name)

    class SecondGrade(
        color: Color = Color(0x7064BAE1),
        name: String = "2학년",
    ): DodamBasicCategory(color, name)

    class ThirdGrade(
        color: Color = Color(0x709856DA),
        name: String = "3학년",
    ): DodamBasicCategory(color, name)

    class AllGrade(
        color: Color = Color(0x70F09771),
        name: String = "전학년",
    ): DodamBasicCategory(color, name)

    class Others(
        color: Color = Color(0x700067BC),
        name: String = "기타",
    ): DodamBasicCategory(color, name)
}
