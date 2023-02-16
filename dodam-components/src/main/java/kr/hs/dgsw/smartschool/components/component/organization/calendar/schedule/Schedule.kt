package kr.hs.dgsw.smartschool.components.component.organization.calendar.schedule

import kr.hs.dgsw.smartschool.components.component.organization.calendar.DodamBasicCalendarCategory
import java.time.LocalDateTime

data class Schedule(
    val title: String,
    val category: DodamBasicCalendarCategory,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val location: String? = null,
)
