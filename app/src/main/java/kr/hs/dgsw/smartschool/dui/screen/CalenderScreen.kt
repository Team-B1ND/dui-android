package kr.hs.dgsw.smartschool.dui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.component.organization.calendar.DaySchedule
import kr.hs.dgsw.smartschool.components.component.organization.calendar.DodamBasicCalendarCategory
import kr.hs.dgsw.smartschool.components.component.organization.calendar.DodamCalendar
import kr.hs.dgsw.smartschool.components.component.organization.calendar.getLocalDateTime
import kr.hs.dgsw.smartschool.components.component.organization.calendar.schedule.DodamScheduleItem
import kr.hs.dgsw.smartschool.components.component.organization.calendar.schedule.Schedule
import kr.hs.dgsw.smartschool.components.component.set.appbar.DodamAppBar
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcCalendar
import kr.hs.dgsw.smartschool.components.theme.Title2
import kr.hs.dgsw.smartschool.dui.DataSet
import java.time.LocalDate

@Composable
@Preview(showBackground = true)
fun CalenderPreview() {
    CalenderScreen(navController = rememberNavController())
}

@Composable
fun CalenderScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DodamColor.Background)
    ) {
        DodamAppBar(title = DataSet.Text.TITLE_CALENDER, onStartIconClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamColor.Background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var selectedDay by remember { mutableStateOf(LocalDate.now()) }
            var selectedSchedules by remember { mutableStateOf(emptyList<DaySchedule>()) }
            Spacer(modifier = Modifier.height(20.dp))
            Title2(text = DataSet.Text.TITLE_CALENDER)
            Spacer(modifier = Modifier.height(20.dp))
            DodamCalendar(schedules = sampleSchedules) { date, daySchedules ->
                selectedDay = date
                selectedSchedules = daySchedules
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 1.dp, color = DodamTheme.color.Gray100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${selectedDay.monthValue}월 ${selectedDay.dayOfMonth}일",
                color = DodamTheme.color.Gray500,
                style = DodamTheme.typography.body3.copy(
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Spacer(modifier = Modifier.width(24.dp))
                IcCalendar(contentDescription = null, tint = DodamTheme.color.Gray500, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(11.dp))
                LazyColumn {
                    items(selectedSchedules) { daySchedule ->
                        DodamScheduleItem(schedule = daySchedule.schedule)
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}

private val sampleSchedules = listOf(
    Schedule(
        title = "1학년 일정",
        category = DodamBasicCalendarCategory.FirstGrade(),
        startDateTime = LocalDate.of(2023, 2, 1).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 15).getLocalDateTime(),
    ),
    Schedule(
        title = "2학년 일정",
        category = DodamBasicCalendarCategory.SecondGrade(),
        startDateTime = LocalDate.of(2023, 2, 5).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 3, 15).getLocalDateTime(),
    ),
    Schedule(
        title = "3학년 일정",
        category = DodamBasicCalendarCategory.ThirdGrade(),
        startDateTime = LocalDate.of(2023, 2, 23).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 3, 7).getLocalDateTime(),
    ),
    Schedule(
        title = "전체 일정",
        category = DodamBasicCalendarCategory.AllGrade(),
        startDateTime = LocalDate.of(2023, 2, 10).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 3, 7).getLocalDateTime(),
    )
)
