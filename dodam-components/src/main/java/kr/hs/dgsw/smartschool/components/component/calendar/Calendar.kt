package kr.hs.dgsw.smartschool.components.component.calendar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import kr.hs.dgsw.smartschool.components.theme.Title1

@Composable
fun DodamCalendar(
    schedules: List<Schedule>,
    modifier: Modifier = Modifier,
) {
    LazyColumn {
        items(schedules) { schedule ->
            Title1(text = "${schedule.title} ${schedule.startDateTime.dayOfMonth} ~ ${schedule.endDateTime.dayOfMonth} ${schedule.category.name}")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewCalendar() {
    DodamCalendar(
        schedules = sampleSchedules,
    )
}

private val sampleSchedules = listOf(
    Schedule(
        title = "비포스쿨",
        category = DodamBasicCategories.FirstGrade(),
        startDateTime = LocalDate.of(2023, 2, 12).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 15).getLocalDateTime(),
    ),
    Schedule(
        title = "겨울방학",
        category = DodamBasicCategories.AllGrade(),
        startDateTime = LocalDate.of(2023, 2, 10).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 28).getLocalDateTime(),
    ),
)