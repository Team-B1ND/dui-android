package kr.hs.dgsw.smartschool.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.smartschool.components.foundation.Text
import kr.hs.dgsw.smartschool.components.modifier.dodamClickable
import kr.hs.smartschool.components.R

val notoSans = FontFamily(
    Font(R.font.noto_sans_thin, FontWeight.Thin),
    Font(R.font.noto_sans_light, FontWeight.Light),
    Font(R.font.noto_sans_regular, FontWeight.Normal),
    Font(R.font.noto_sans_medium, FontWeight.Medium),
    Font(R.font.noto_sans_bold, FontWeight.Bold),
    Font(R.font.noto_sans_black, FontWeight.Black)
)

object DodamTypography {

    @Stable
    val display1 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
    )

    @Stable
    val display2 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp
    )

    @Stable
    val display3 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp
    )

    @Stable
    val headline1 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp
    )

    @Stable
    val headline2 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp
    )

    @Stable
    val headline3 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp
    )

    @Stable
    val title1 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp
    )

    @Stable
    val title2 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    @Stable
    val title3 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

    @Stable
    val label1 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 10.sp
    )

    @Stable
    val label2 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )

    @Stable
    val label3 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp
    )

    @Stable
    val body1 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

    @Stable
    val body3 = TextStyle(
        fontFamily = notoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
}

@Composable
fun Display1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.display1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Display2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.display2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Display3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.display3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Headline1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.headline1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Headline2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.headline2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Headline3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.headline3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Title1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.title1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Title2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.title2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Title3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.title3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Label1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.label1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Label2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.label2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Label3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.label3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.body1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.body2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.body3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

@Composable
fun DodamError(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DodamColor.Error,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true,
) {
    Text(
        modifier = modifier.dodamClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DodamTypography.body3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
    )
}

internal val LocalTypography = staticCompositionLocalOf { DodamTypography }
