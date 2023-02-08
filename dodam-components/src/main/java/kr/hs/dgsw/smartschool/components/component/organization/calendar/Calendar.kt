package kr.hs.dgsw.smartschool.components.component.organization.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.component.basic.Divider
import kr.hs.dgsw.smartschool.components.component.organization.calendar.schedule.Schedule
import kr.hs.dgsw.smartschool.components.component.organization.calendar.schedule.DodamScheduleItem
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcCalendar
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen
import java.time.LocalDate

/**
 * Dodam Calendar, for schedule
 *
 * @param schedules schedules(events) list type
 * @param modifier modifier
 * @param categories use DodamBasicCalendarCategory, list type
 * @param showCategories visible state category
 * @param onDayChange callback when day state changed, (currentDate, daySchedules)
 */
@Composable
fun DodamCalendar(
    schedules: List<Schedule>,
    modifier: Modifier = Modifier,
    categories: List<DodamBasicCalendarCategory> = dodamBasicCalendarCategories,
    showCategories: Boolean = true,
    onDayChange: (date: LocalDate, daySchedules: List<DaySchedule>) -> Unit = { _, _ -> Unit },
) {
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }
    onDayChange(selectedDay, selectedDay.hasSchedules(schedules))

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Category Bar
        if (showCategories) {
            Spacer(modifier = Modifier.height(16.dp))
            CategoryBar(categories = categories)
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Top Bar
        CalendarTopBar(
            dayTitle = "${selectedDay.year}년 ${selectedDay.monthValue}월",
            onClickMinus = { selectedDay = selectedDay.minusMonths(1) },
            onClickPlus = { selectedDay = selectedDay.plusMonths(1) }
        )
        Spacer(modifier = Modifier.height(19.dp))
        DayOfWeekBar()
        Spacer(modifier = Modifier.height(5.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DodamDimen.ScreenSidePadding),
            userScrollEnabled = false,
            contentPadding = PaddingValues(all = 1.dp),
        ) {
            items(selectedDay.getMonthDays()) { monthDay ->
                DayItem(selectedDay = selectedDay, monthDay = monthDay, schedules = schedules) {
                    val selected = LocalDate.of(selectedDay.year, selectedDay.monthValue, it)
                    if (selectedDay.isEqual(selected).not()) {
                        selectedDay = selected
                    }
                }
            }
        }
    }
}

@Composable
private fun DayItem(
    selectedDay: LocalDate,
    monthDay: MonthDay,
    schedules: List<Schedule>,
    onClickItem: (day: Int) -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = if (selectedDay.dayOfMonth == monthDay.day)
                    DodamTheme.color.Gray100
                else
                    DodamTheme.color.Transparent,
                shape = DodamTheme.shape.small,
            )
            .dodamClickable(rippleEnable = false) {
                if (monthDay.day != -1)
                    onClickItem(monthDay.day)
            }
    ) {
        var textColor = DodamTheme.color.Black
        if (monthDay.day != -1)
            if (LocalDate.now().isEqual(LocalDate.of(selectedDay.year, selectedDay.monthValue, monthDay.day))) {
                TodayIndicationBox()
                textColor = DodamTheme.color.White
            }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            if (monthDay.day != -1) {
                Spacer(modifier = Modifier.height(3.dp))
                BasicDayText(textColor = textColor, monthDay = monthDay)
                Spacer(modifier = Modifier.height(6.dp))
                val daySchedules = LocalDate.of(selectedDay.year, selectedDay.monthValue, monthDay.day)
                    .hasSchedules(schedules)
                if (daySchedules.isNotEmpty()) {
                    daySchedules.forEach {
                        when (it.type) {
                            DayScheduleType.START -> ScheduleStartHorizontalBar(color = it.schedule.category.color)
                            DayScheduleType.MIDDLE -> ScheduleMiddleHorizontalBar(color = it.schedule.category.color)
                            DayScheduleType.END -> ScheduleEndHorizontalBar(color = it.schedule.category.color)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun BoxScope.TodayIndicationBox() {
    Column(
        modifier = Modifier.align(Alignment.TopCenter)
    ) {
        Spacer(modifier = Modifier.height(3.dp))
        Box(
            modifier = Modifier
                .background(DodamTheme.color.Black, shape = DodamTheme.shape.small)
                .size(15.dp)
        )
    }
}

@Composable
private fun ColumnScope.BasicDayText(textColor: Color, monthDay: MonthDay) {
    Text(
        text = monthDay.day.toString(),
        color = if ((monthDay.dayOfWeek == 0) || (monthDay.dayOfWeek == 6))
            DodamColor.FeatureColor.ScheduleColor
        else
            textColor,
        style = DodamTheme.typography.body3.copy(
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 10.sp,
        ),
        modifier = Modifier.align(Alignment.CenterHorizontally)
    )
}

@Composable
private fun ScheduleEndHorizontalBar(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(color, shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .padding(end = 2.dp)
    )
}

@Composable
private fun ScheduleStartHorizontalBar(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(color, shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
            .padding(start = 2.dp)
    )
}

@Composable
private fun ScheduleMiddleHorizontalBar(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(color)
    )
}

@Composable
private fun CategoryBar(
    categories: List<DodamBasicCalendarCategory>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(categories) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
private fun CategoryItem(category: DodamBasicCalendarCategory) {
    Row {
        Box(
            modifier = Modifier
                .background(
                    color = category.color,
                    shape = DodamTheme.shape.small,
                )
                .size(12.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = category.name,
            style = DodamTheme.typography.body3.copy(
                color = Color.Black,
                fontSize = 10.sp,
                lineHeight = 12.sp,
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun CalendarTopBar(
    dayTitle: String,
    onClickPlus: () -> Unit,
    onClickMinus: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = DodamDimen.ScreenSidePadding)
            .fillMaxWidth()
    ) {
        Text(
            text = dayTitle,
            style = DodamTheme.typography.label1.copy(
                color = DodamTheme.color.Black,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )

        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            IcLeftArrow(
                modifier = Modifier
                    .size(15.dp)
                    .dodamClickable(rippleEnable = false) { onClickMinus() },
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(12.dp))
            IcRightArrow(
                modifier = Modifier
                    .size(15.dp)
                    .dodamClickable(rippleEnable = false) { onClickPlus() },
                contentDescription = null,
            )
        }
    }
}

private val dayOfWeeks = listOf("일", "월", "화", "수", "목", "금", "토")

@Composable
private fun DayOfWeekBar() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DodamDimen.ScreenSidePadding),
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        items(dayOfWeeks) { dayOfWeek ->
            Text(
                text = dayOfWeek,
                style = DodamTheme.typography.body3.copy(
                    color = if (dayOfWeek == "일" || dayOfWeek == "토")
                        DodamColor.FeatureColor.ScheduleColor
                    else
                        DodamTheme.color.Black,
                    fontSize = 10.sp,
                    lineHeight = 10.sp,
                ),
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCalendar() {
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }
    var selectedSchedules by remember { mutableStateOf(emptyList<DaySchedule>()) }

    Column(Modifier.fillMaxSize()) {
        DodamCalendar(
            schedules = sampleSchedules,
        ) { date, schedules ->
            selectedDay = date
            selectedSchedules = schedules
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

@Preview
@Composable
private fun PreviewCategoryItem() {
    CategoryItem(category = DodamBasicCalendarCategory.FirstGrade())
}

private val sampleSchedules = listOf(
    Schedule(
        title = "비포스쿨",
        category = DodamBasicCalendarCategory.FirstGrade(),
        startDateTime = LocalDate.of(2023, 2, 12).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 15).getLocalDateTime(),
    ),
    Schedule(
        title = "겨울방학",
        category = DodamBasicCalendarCategory.AllGrade(),
        startDateTime = LocalDate.of(2023, 2, 10).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 3, 7).getLocalDateTime(),
    ),
)
