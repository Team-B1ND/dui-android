package kr.hs.dgsw.smartschool.components.component.calendar

import java.time.LocalDateTime

data class Schedule(
    val title: String,
    val category: DodamBasicCategory,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val location: String? = null,
)
