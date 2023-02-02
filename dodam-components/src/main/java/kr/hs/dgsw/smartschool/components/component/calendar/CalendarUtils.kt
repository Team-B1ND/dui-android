package kr.hs.dgsw.smartschool.components.component.calendar

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun LocalDate.getLocalDateTime(): LocalDateTime =
    LocalDateTime.of(this, LocalTime.of(9, 0))

fun getLocalDateTime(year: Int, month: Int, day: Int): LocalDateTime =
    LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(9, 0))

fun LocalDate.getMonthDays() : List<MonthDay> {

    val monthDays = mutableListOf<MonthDay>()
    val year = this.year
    val month = this.monthValue

    val date = LocalDate.of(year, month, 1)
    // 0 ~ 6으로 일요일이 0, 토요일이 6
    val dayOfWeek = date.dayOfWeek.value
    val dayOfWeekData = if (dayOfWeek == 7) 0 else dayOfWeek

    // 시작일 앞의 빈 주 채우기
    for (i in 0 until dayOfWeekData) {
        monthDays.add(MonthDay(-1, -1))
    }

    // 실제 값 채우기
    for (i in 1 .. this.lengthOfMonth()) {
        val realDate = LocalDate.of(year, month, i)
        val realDayOfWeekData = realDate.dayOfWeek.value
        monthDays.add(MonthDay(i, if (realDayOfWeekData == 7) 0 else realDayOfWeekData))
    }

    return monthDays
}

data class MonthDay(
    val day: Int,
    val dayOfWeek: Int, // 0 ~ 6
)

