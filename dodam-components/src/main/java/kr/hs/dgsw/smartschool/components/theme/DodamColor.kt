package kr.hs.dgsw.smartschool.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import kr.hs.dgsw.smartschool.components.theme.DodamColor.FeatureColor

/**
 * 도담도담 컬러를 정의합니다.
 */
object DodamColor {

    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    val Background = Color(0xFFF3F4F6)

    val Check = Color(0xFF48A068)
    val Error = Color(0xFFDE5257)

    val Breakfast = Color(0xFFFCA800)
    val Lunch = Color(0xFF3DBDE5)
    val Dinner = Color(0xFFA252E1)

    val Transparent = Color(0x00000000)

    val MainColor = Color(0xFF0067BC)

    val MainColor50 = Color(0xFFF0F8FF)
    val MainColor100 = Color(0xFFBDE1FF)
    val MainColor200 = Color(0xFF8ACAFF)
    val MainColor300 = Color(0xFF57B3FF)
    val MainColor400 = Color(0xFF249CFF)
    val MainColor500 = Color(0xFF0083F0)
    val MainColor600 = Color(0xFF0067BC)
    val MainColor700 = Color(0xFF004B8A)
    val MainColor800 = Color(0xFF003057)
    val MainColor900 = Color(0xFF001424)

    val SecondaryColor = Color(0xFFBC0067)

    val SecondaryColor50 = Color(0xFFFFF0F8)
    val SecondaryColor100 = Color(0xFFFFBDE1)
    val SecondaryColor200 = Color(0xFFFF8ACA)
    val SecondaryColor300 = Color(0xFFFF57B3)
    val SecondaryColor400 = Color(0xFFFF249C)
    val SecondaryColor500 = Color(0xFFF00084)
    val SecondaryColor600 = Color(0xFFBC0067)
    val SecondaryColor700 = Color(0xFF8A004C)
    val SecondaryColor800 = Color(0xFF570030)
    val SecondaryColor900 = Color(0xFF240014)

    val Gray50 = Color(0xFFEEEEF1)
    val Gray100 = Color(0xFFD2D2DB)
    val Gray200 = Color(0xFFB5B5C4)
    val Gray300 = Color(0xFF9999AD)
    val Gray400 = Color(0xFF7D7D97)
    val Gray500 = Color(0xFF64647D)
    val Gray600 = Color(0xFF4D4D60)
    val Gray700 = Color(0xFF363644)
    val Gray800 = Color(0xFF202028)
    val Gray900 = Color(0xFF09090B)

    object FeatureColor {
        val SongColor = Color(0xFFF09771)
        val ScheduleColor = Color(0xFFFF585A)
        val LostFoundColor = Color(0xFF3BACB6)
        val ItMapColor = Color(0xFF25316D)
        val MyInfoColor = Color(0xFF03C75A)
    }
}

@Composable
fun contentColorFor(backgroundColor: Color) =
    DodamColor.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

private fun DodamColor.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        MainColor -> White
        SecondaryColor -> White
        Error -> White
        Gray100 -> White
        Background -> Black
        White -> Black
        FeatureColor.SongColor -> White
        FeatureColor.ScheduleColor -> White
        FeatureColor.LostFoundColor -> White
        FeatureColor.ItMapColor -> White
        FeatureColor.MyInfoColor -> White
        else -> White
    }
}

internal val LocalColor = staticCompositionLocalOf { DodamColor }
internal val LocalContentColor = compositionLocalOf { Color.Black }
internal val LocalContentAlpha = compositionLocalOf { 1f }
