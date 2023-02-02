package kr.hs.dgsw.smartschool.components.component.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import java.time.LocalDate
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcLeftArrow
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

@Composable
fun DodamCalendar(
    schedules: List<Schedule>,
    modifier: Modifier = Modifier,
    categories: List<DodamBasicCategory> = dodamBasicCategories,
    showCategories: Boolean = true,
) {
    val today = LocalDate.now()
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }

    Column(
        modifier = modifier.fillMaxWidth()
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
            contentPadding = PaddingValues(all = 1.dp)
        ) {

            items(selectedDay.getMonthDays()) { monthDays ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                ) {
                    if (monthDays.day != -1)
                        Text(
                            text = monthDays.day.toString(),
                            color = if ((monthDays.dayOfWeek == 0) || (monthDays.dayOfWeek == 6))
                                DodamColor.FeatureColor.ScheduleColor
                            else
                                DodamTheme.color.Black,
                            style = DodamTheme.typography.body3.copy(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = 10.sp,
                            ),
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                }
            }
        }

    }
}

@Composable
private fun CategoryBar(
    categories: List<DodamBasicCategory>
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
private fun CategoryItem(category: DodamBasicCategory) {
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
    Row(modifier = Modifier
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
    DodamCalendar(
        schedules = sampleSchedules,
    )
}

@Preview
@Composable
private fun PreviewCategoryItem() {
    CategoryItem(category = DodamBasicCategory.FirstGrade())
}

private val sampleSchedules = listOf(
    Schedule(
        title = "비포스쿨",
        category = DodamBasicCategory.FirstGrade(),
        startDateTime = LocalDate.of(2023, 2, 12).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 15).getLocalDateTime(),
    ),
    Schedule(
        title = "겨울방학",
        category = DodamBasicCategory.AllGrade(),
        startDateTime = LocalDate.of(2023, 2, 10).getLocalDateTime(),
        endDateTime = LocalDate.of(2023, 2, 28).getLocalDateTime(),
    ),
)

