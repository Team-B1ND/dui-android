package kr.hs.dgsw.smartschool.components.component.calendar.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.component.calendar.toKoreanDateTime
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.Body2
import kr.hs.dgsw.smartschool.components.theme.DodamTheme

@Composable
fun ScheduleItem(
    schedule: Schedule,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(16.dp)
                .padding(top = 4.dp)
                .background(color = schedule.category.color, shape = DodamTheme.shape.large)
                .align(Alignment.Top)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Column {
            Body2(text = schedule.title, textColor = DodamTheme.color.Black)
            Text(
                text = "${schedule.startDateTime.toKoreanDateTime()} - ${schedule.endDateTime.toKoreanDateTime()} / ${schedule.category.name}",
                color = DodamTheme.color.Gray500,
                style = DodamTheme.typography.body3.copy(
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                )
            )
        }
    }
}