package kr.hs.dgsw.smartschool.components.component.organization.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.theme.Body3
import kr.hs.dgsw.smartschool.components.theme.DodamTheme
import kr.hs.dgsw.smartschool.components.theme.IcDinner3D
import kr.hs.dgsw.smartschool.components.theme.IcOut3D
import kr.hs.dgsw.smartschool.components.theme.IcRightArrow
import kr.hs.dgsw.smartschool.components.theme.contentColorFor
import kr.hs.dgsw.smartschool.components.utlis.DodamDimen

/**
 * Dodam Item Card, set title, subtitle, icon
 *
 * @param title card title
 * @param subTitle card subTitle
 * @param modifier modifier
 * @param onClick action when click card
 * @param icon card icon
 * @param shape card shape, basic is large
 * @param background card background color
 * @param titleStyle title text style
 * @param subTitleStyle subTitle text style
 * @param enable card active state
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 */
@Composable
fun DodamItemCard(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    titleStyle: TextStyle = DodamTheme.typography.label1,
    subTitleStyle: TextStyle = DodamTheme.typography.body3,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
) {
    Card(
        onClick = if (enable) onClick else null,
        modifier = modifier.width(120.dp),
        shape = shape,
        background = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = DodamDimen.CardSidePadding,
                    vertical = DodamDimen.CardSidePadding
                )
                .fillMaxWidth(),
        ) {
            Text(text = subTitle, style = subTitleStyle.copy(color = DodamTheme.color.Gray500))
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = title, style = titleStyle.copy(color = contentColorFor(backgroundColor = background)))
            icon?.let {
                Spacer(modifier = Modifier.height(14.dp))
                Box(modifier = modifier.align(Alignment.End)) {
                    it()
                }
            }
        }
    }
}

/**
 * Dodam Content Card, set title, contents
 *
 * @param title card title
 * @param modifier modifier
 * @param onClick action when click card
 * @param hasLinkIcon link to other page icon
 * @param shape card shape, basic is large
 * @param background card background color
 * @param titleStyle title text style
 * @param enable card active state
 * @param rippleColor rippleColor
 * @param rippleEnable rippleEnable
 * @param bounded bounded
 * @param content composable content in card
 */
@Composable
fun DodamContentCard(
    title: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    hasLinkIcon: Boolean = false,
    shape: Shape = DodamTheme.shape.large,
    background: Color = DodamTheme.color.White,
    titleStyle: TextStyle = DodamTheme.typography.title2,
    enable: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = true,
    bounded: Boolean = true,
    content: (@Composable () -> Unit)? = null
) {
    Card(
        onClick = if (enable) onClick else null,
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        background = background,
        rippleEnable = rippleEnable,
        rippleColor = rippleColor,
        bounded = bounded,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = DodamDimen.CardSidePadding,
                    vertical = DodamDimen.CardSidePadding
                )
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    text = title,
                    style = titleStyle.copy(contentColorFor(backgroundColor = background)),
                    modifier = Modifier.weight(1f)
                )
                if (hasLinkIcon) {
                    Spacer(modifier = Modifier.height(14.dp))
                    IcRightArrow(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.CenterVertically),
                        tint = DodamTheme.color.Gray400,
                        contentDescription = null
                    )
                }
            }
            content?.let {
                Spacer(modifier = Modifier.height(DodamDimen.CardSidePadding))
                it()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDodamCard() {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(DodamDimen.ScreenSidePadding)
            .verticalScroll(scroll)
    ) {
        Row {
            DodamItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
            )

            Spacer(modifier = Modifier.width(10.dp))

            DodamItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
                icon = { IcOut3D(contentDescription = null) }
            )

            Spacer(modifier = Modifier.width(10.dp))

            DodamItemCard(
                title = "외출 / 외박",
                subTitle = "신청",
                icon = { IcOut3D(contentDescription = null) },
                onClick = {}
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        DodamContentCard(title = "오늘의 석식")

        Spacer(modifier = Modifier.height(10.dp))
        DodamContentCard(title = "오늘의 석식", hasLinkIcon = true)

        Spacer(modifier = Modifier.height(10.dp))
        DodamContentCard(title = "오늘의 석식", hasLinkIcon = true) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IcDinner3D(contentDescription = null, modifier = Modifier.size(32.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Body3(text = "오늘은 급식이 없네요!", modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        DodamMealCard(content = "오늘은 급식이 없어요!", mealType = MealType.BreakFast)
        Spacer(modifier = Modifier.height(10.dp))
        DodamMealCard(content = "*기장밥, 김치어묵국, *명태껍질볶음, 새송이돈육마늘구이, *짜먹는요거트, *꽃상추쌈/쌈장", mealType = MealType.Lunch)
        Spacer(modifier = Modifier.height(10.dp))
        DodamMealCard(content = "*기장밥, 김치어묵국, *명태껍질볶음, 새송이돈육마늘구이, *짜먹는요거트, *꽃상추쌈/쌈장*기장밥, 김치어묵국, *명태껍질볶음, 새송이돈육마늘구이, *짜먹는요거트, *꽃상추쌈/쌈장*기장밥, 김치어묵국, *명태껍질볶음, 새송이돈육마늘구이, *짜먹는요거트, *꽃상추쌈/쌈장", mealType = MealType.Dinner)
    }
}
