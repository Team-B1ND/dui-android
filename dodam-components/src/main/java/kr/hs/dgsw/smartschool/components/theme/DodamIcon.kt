package kr.hs.dgsw.smartschool.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kr.hs.dgsw.smartschool.components.foundation.Icon
import kr.hs.smartschool.components.R

@Composable
fun IcLeftArrow(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_left_arrow),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcRightArrow(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_right_arrow),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcCheck(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_check),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcHome(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_home),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcMeal(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_meal),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcSong(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_song),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcX(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_add),
        contentDescription = contentDescription,
        modifier = modifier.rotate(45f),
        tint = tint
    )
}

@Composable
fun IcUser(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_user),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcAdd(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_add),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcDelete(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_delete),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcGallery(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_gallery),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcCalendar(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_calendar),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcSearch(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcBreakfast3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_breakfast_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcLunch3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_lunch_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcDinner3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_dinner_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcSong3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_song_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcOut3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_out_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcItmap3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_itmap_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcLostFound3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_lost_found_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcPoint3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_point_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcBus3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_bus_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcSetting3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_setting_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcDocument3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_document_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcInfo3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_info_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcLock3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_lock_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcLogout3D(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color? = null,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_logout_3d),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}
