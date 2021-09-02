package ga.veee.traveljournal.ui.screens

import android.app.Activity
import android.widget.CalendarView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.google.accompanist.insets.LocalWindowInsets
import ga.veee.traveljournal.R
import ga.veee.traveljournal.ui.theme.Gunmetal
import ga.veee.traveljournal.ui.theme.Poppins
import ga.veee.traveljournal.utils.getFormattedDate
import ga.veee.traveljournal.utils.makeActivityFullScreen
import java.util.*


@OptIn(ExperimentalAnimationApi::class)
@ExperimentalComposeUiApi
@Composable
fun NewJournalScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)
            .background(Color.White)
    ) {
        NavTopNewJournal(navController = navController)
        NewJournalForm()
    }
}


@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun NewJournalForm() {

    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(0L) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val insets = LocalWindowInsets.current
    val imeBottom = with(LocalDensity.current) { insets.ime.bottom.toDp() }

    if (!showDatePicker) {
        makeActivityFullScreen(LocalContext.current as Activity)
    }

    if (showDatePicker)
        AlertDialog(
            title = {
                Text(text = "Select Date")
            },
            text = {
                AndroidView(
                    { CalendarView(it) },
                    modifier = Modifier.wrapContentWidth(),
                    update = { calendarView ->
                        calendarView.maxDate = System.currentTimeMillis()
                        calendarView.setOnDateChangeListener { _, year, month, date ->
                            val calendar = Calendar.getInstance(Locale.getDefault())
                            calendar.set(year, month, date)
                            selectedDate = calendar.timeInMillis
                            showDatePicker = !showDatePicker
                        }
                    }
                )
            },
            buttons = {
            },
            onDismissRequest = {
                showDatePicker = !showDatePicker
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        )

    BoxWithConstraints(Modifier.fillMaxWidth()) {

        val constraints = constraints
        val scrollState = rememberScrollState()

        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
                .padding(bottom = imeBottom)
        ) {

            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Cover",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                BoxWithConstraints(
                    Modifier
                        .fillMaxWidth()
                        .height((constraints.maxHeight / 8.0F).dp)
                        .clip(shape = RoundedCornerShape(percent = 6))
                        .background(color = Color(0XFF94A3B8))
                        .clickable {
                        }
                        .focusable()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        Modifier.align(
                            Alignment.Center
                        )
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Title",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    singleLine = true,
                    isError = false,
                    enabled = true,
                    textStyle = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Gunmetal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
            }

            Spacer(Modifier.height(8.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Date",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.calendar),
                            contentDescription = "Calender",
                            Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                    },
                    value = if (selectedDate > 0) getFormattedDate(selectedDate) else "",
                    onValueChange = { },
                    singleLine = true,
                    isError = false,
                    enabled = false,
                    textStyle = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Gunmetal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable {
                            showDatePicker = true
                        },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Spacer(Modifier.height(8.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Description",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Gunmetal,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    singleLine = false,
                    isError = false,
                    enabled = true,
                    textStyle = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Gunmetal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Spacer(Modifier.height(20.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(percent = 10)
                    )
                    .clip(RoundedCornerShape(percent = 10))
                    .background(color = Color.White)
                    .padding(12.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gallery_black),
                        contentDescription = null,
                        Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                    Text(
                        text = "Photos",
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                        fontSize = 18.sp
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null,
                    Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clip(shape = RoundedCornerShape(percent = 100))
                        .clickable { }
                )
            }
            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Create Journal",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                    )
                    AnimatedVisibility(visible = false) {
                        Spacer(modifier = Modifier.width(8.dp))
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            strokeWidth = 2.dp,
                            progress = 0.0F
                        )
                    }
                }
            }
            Spacer(Modifier.height(20.dp))

        }

    }
}

@Composable
fun NavTopNewJournal(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left_black),
            contentDescription = "Left",
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 36.dp,
                    bottom = 16.dp
                )
                .clickable {
                    navController.popBackStack()
                }
        )
        Text(
            text = "New Journal",
            color = Gunmetal,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.width(24.dp))
    }
}