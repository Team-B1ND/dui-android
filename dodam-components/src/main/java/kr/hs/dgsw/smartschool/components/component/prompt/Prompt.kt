package kr.hs.dgsw.smartschool.components.component.prompt

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kr.hs.dgsw.smartschool.components.component.button.ButtonType
import kr.hs.dgsw.smartschool.components.component.button.DodamMediumRoundedButton
import kr.hs.dgsw.smartschool.components.theme.Body1
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.Title2

@Composable
fun DodamPrompt(
    title: String,
    primaryButton: @Composable () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    secondaryButton: @Composable (() -> Unit)? = null,
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = modifier
                .background(
                    color = DodamTheme.color.White,
                    shape = DodamTheme.shape.medium,
                )
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                ),
        ) {
            Title2(text = title, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(2.dp))
            description?.let {
                Body1(text = it, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                secondaryButton?.let {
                    it()
                    Spacer(modifier = Modifier.width(16.dp))
                }

                primaryButton()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDodamPrompt() {
    var showPrompt by remember {
        mutableStateOf(false)
    }

    if (showPrompt) {
        DodamPrompt(
            title = "Test DodamPrompt",
            description = "TestTestTestTestTestTest",
            secondaryButton = {
                DodamMediumRoundedButton(text = "No", type = ButtonType.Danger) {
                    showPrompt = false
                }
            },
            primaryButton = {
                DodamMediumRoundedButton(text = "Yes") {
                    showPrompt = false
                }
            },
            onDismiss = { showPrompt = false }
        )
    }

    Box(Modifier.fillMaxSize()) {
        DodamMediumRoundedButton(text = "Show Prompt") {
            showPrompt = true
        }
    }
}
