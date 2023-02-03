package kr.hs.dgsw.smartschool.components.component.calendar.schedule

import java.time.LocalDateTime
import kr.hs.dgsw.smartschool.components.component.calendar.DodamBasicCalendarCategory

data class Schedule(
    val title: String,
    val category: DodamBasicCalendarCategory,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val location: String? = null,
)
