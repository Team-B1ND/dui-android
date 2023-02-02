package kr.hs.dgsw.smartschool.components.component.calendar

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun LocalDate.getLocalDateTime(): LocalDateTime =
    LocalDateTime.of(this, LocalTime.of(9, 0))

fun getLocalDateTime(year: Int, month: Int, day: Int): LocalDateTime =
    LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(9, 0))
