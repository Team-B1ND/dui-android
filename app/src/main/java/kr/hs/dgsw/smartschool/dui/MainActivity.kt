package kr.hs.dgsw.smartschool.dui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.hs.dgsw.smartschool.components.component.button.*
import kr.hs.dgsw.smartschool.components.component.input.Input
import kr.hs.dgsw.smartschool.components.theme.*
import kr.hs.dgsw.smartschool.dui.ui.theme.DuiTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DodamColor.Background
                ) {
                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(scrollState),
                    ) {
                        DodamDisplayText()
                        DodamHeadlineText()
                        DodamTitleText()
                        DodamLabelText()
                        DodamBodyText()
                        DodamError(text = "도담도담 Error Text")
                        IcBreakfast3D(contentDescription = null)
                        DodamSmallRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Small")
                        Spacer(modifier = Modifier.height(8.dp))
                        DodamMediumRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "도담도담 버튼", type = ButtonType.Danger, iconLeft = { IcSong(contentDescription = null) })
                        Spacer(modifier = Modifier.height(8.dp))
                        DodamLargeRoundedButton(onClick = { sampleOnClick(this@MainActivity) }, text = "Large", type = ButtonType.Disable, enable = false)
                        Spacer(modifier = Modifier.height(8.dp))
                        IconButton(icon = { IcSong(contentDescription = null) }, onClick = { sampleOnClick(this@MainActivity) }, type = ButtonType.Danger)

                        Spacer(modifier = Modifier.height(8.dp))

                        val radioState = remember { mutableStateOf(true) }
                        Row {
                            RadioButton(selected = radioState.value, onClick = { radioState.value = !radioState.value }, type = ButtonType.Itmap)
                            Spacer(modifier = Modifier.width(8.dp))
                            Body2(text = "Radio", modifier = Modifier.align(Alignment.CenterVertically))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val testValue = remember { mutableStateOf("") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = testValue.value,
                            hint = "테스트 값을 입력해 주세요!",
                            onValueChange = { testValue.value = it },
                            focusColor = DodamColor.FeatureColor.LostFoundColor,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        val value = remember { mutableStateOf("Test Input") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = value.value,
                            hint = "Test Hint",
                            onValueChange = { value.value = it },
                            leadingIcon = { IcSong(contentDescription = null) },
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        val value2 = remember { mutableStateOf("Test Input2") }
                        Input(
                            modifier = Modifier.fillMaxWidth(),
                            value = value2.value,
                            hint = "Test Hint2",
                            isError = true,
                            errorMessage = "응애 에러 발생 에러 발생",
                            onValueChange = { value2.value = it },
                            trailingIcon = { IcX(contentDescription = null, modifier = Modifier.clickable { value2.value = "" }) },
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        MainScreen(viewModel = null)  
    }
}

data class Item(
    val icon : Int,
    val title : String,
    val content : String
    )


@Composable
fun MainScreen(viewModel : ViewModel?){
    val list : List<Item> = listOf(
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용"),
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용"),
        Item(kr.hs.smartschool.components.R.drawable.ic_breakfast_3d,"제목","내용")
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ListScreen(list = list)
    }
}
@Composable
fun ListScreen(
    list : List<Item>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Title1(
            text = "DUI",
            modifier = Modifier
                .padding(start = 30.dp, bottom = 50.dp)
        )
        ColumnList(list = list)
    }
}

@Composable
fun ColumnList(list : List<Item>){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        list.let {
            items(it) { item ->
                ColumnItemCard(
                    item = item
                )
            }
        }
    }
}

@Composable
fun ColumnItemCard(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        elevation = 3.dp
    ) {
        Column(modifier = Modifier
            .height(100.dp)
            .width(300.dp)
            .padding(all = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) {
                ItemImage(
                    item.icon
                )
                Title3(
                    text = item.title
                )
            }
            Body3(text = "내용")
        }
    }
}

@Composable
fun ItemImage(icon : Int){
    Surface(shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp))) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}

private fun sampleOnClick(context: Context) {
    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
}

@Composable
fun DodamDisplayText() {
    Column {
        Display1(text = "도담도담 Display1", onClick = {}, rippleColor = DodamColor.MainColor)
        Display2(text = "도담도담 Display2")
        Display3(text = "도담도담 Display3")
    }
}

@Composable
fun DodamHeadlineText() {
    Column {
        Headline1(text = "도담도담 Headline1")
        Headline2(text = "도담도담 Headline2")
        Headline3(text = "도담도담 Headline3")
    }
}

@Composable
fun DodamTitleText() {
    Column {
        Title1(text = "도담도담 Title1")
        Title2(text = "도담도담 Title2")
        Title3(text = "도담도담 Title3")
    }
}

@Composable
fun DodamLabelText() {
    Column {
        Label1(text = "도담도담 Label1")
        Label2(text = "도담도담 Label2")
        Label3(text = "도담도담 Label3")
    }
}

@Composable
fun DodamBodyText() {
    Column {
        Body1(text = "도담도담 Body1")
        Body2(text = "도담도담 Body2")
        Body3(text = "도담도담 Body3")
    }
}

//@Preview(showBackground = true)
@Composable
fun DisplayTextPreview() {
    DuiTheme {
        DodamDisplayText()
    }
}

//@Preview(showBackground = true)
@Composable
fun HeadlineTextPreview() {
    DuiTheme {
        DodamHeadlineText()
    }
}

//@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    DuiTheme {
        DodamTitleText()
    }
}

//@Preview(showBackground = true)
@Composable
fun LabelTextPreview() {
    DuiTheme {
        DodamLabelText()
    }
}

//@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    DuiTheme {
        DodamBodyText()
    }
}

//@Preview(showBackground = true)
@Composable
fun IcBack() {
    IcLeftArrow(contentDescription = null, tint = DodamColor.MainColor)
}

//@Preview(showBackground = true)
@Composable
fun ErrorTextPreview() {
    DuiTheme {
        DodamError(text = "도담도담 Error Text")
    }
}
