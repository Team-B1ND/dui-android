package kr.hs.dgsw.smartschool.components.component.calendar.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kr.hs.dgsw.smartschool.components.component.button.ButtonType
import kr.hs.dgsw.smartschool.components.component.button.DodamLargeRoundedButton
import kr.hs.dgsw.smartschool.components.component.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.component.calendar.DodamCalendar
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.dgsw.smartschool.components.theme.DodamColor
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Label2
import kr.hs.dgsw.smartschool.components.theme.Title1
import java.time.LocalDate

@Composable
fun CalendarDialog(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = ButtonType.Schedule,
    secondaryColor: Color = DodamColor.FeatureColor.ScheduleColor,
    onDismiss: (selectedDate: LocalDate?) -> Unit,
) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Dialog(
        onDismissRequest = { onDismiss(null) }
    ) {

        Box(
            modifier = modifier.background(
                color = DodamTheme.color.White,
                shape = DodamTheme.shape.medium,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                DodamCalendar(
                    schedules = emptyList(),
                    showCategories = false,
                ) { date, _ ->
                    selectedDate = date
                }

                Spacer(modifier = Modifier.height(100.dp))
            }

            Row(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Label2(
                    text = "CANCEL",
                    textColor = secondaryColor,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .dodamClickable(rippleEnable = false) {
                            onDismiss(null)
                        }
                )
                Spacer(modifier = Modifier.width(12.dp))

                DodamLargeRoundedButton(
                    text = "DONE",
                    type = buttonType,
                ) {
                    onDismiss(selectedDate)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDodamCalendarDialog() {
    var showPrompt by remember {
        mutableStateOf(false)
    }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    if (showPrompt) {
        CalendarDialog { date ->
            showPrompt = false
            date?.let {
                selectedDate = it
            }
        }
    }

    Column(Modifier.fillMaxSize()) {
        DodamMediumRoundedButton(text = "Show Prompt") {
            showPrompt = true
        }
        Title1(text = selectedDate.toString())
    }
}
