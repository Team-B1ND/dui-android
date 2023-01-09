package kr.hs.dgsw.smartschool.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun DodamTheme(
    color: DodamColor = DodamTheme.color,
    typography: DodamTypography = DodamTheme.typography,
    shape: DodamShape = DodamTheme.shape,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typography,
        LocalShape provides shape
    ) {
        content()
    }
}

object DodamTheme {
    val color: DodamColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val typography: DodamTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: DodamShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current
}
