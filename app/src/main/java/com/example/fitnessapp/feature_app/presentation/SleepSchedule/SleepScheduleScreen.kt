package com.example.fitnessapp.feature_app.presentation.SleepSchedule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.AddAlarm.AddAlarmEvent
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel

@Composable
fun SleepScheduleScreen(navController: NavController, vm: SleepScheduleVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(SleepScheduleEvent.GetSleep)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .padding(horizontal = 30.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Home.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.back_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    Text(text = "График сна",
                        color = Color.Black,
                        fontWeight = FontWeight(700),
                        fontSize = 16.sp,
                        fontFamily = montserratBold
                    )
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(painter = painterResource(R.drawable.details_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                }
                Box(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .background(Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.buttonGrStart),
                            colorResource(R.color.buttonGrEnd)
                        )
                    ),
                        shape = RoundedCornerShape(22.dp),
                        alpha = 0.2f)){
                    Row(modifier = Modifier
                        .padding(start = 20.dp)
                        .padding(top = 26.dp)) {
                        Column {
                            Text(
                                text = "Идеальные часы для сна",
                                color = Color.Black,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = montserratRegular
                            )
                            Text(
                                text = "8 часов 30 минут",
                                color = colorResource(R.color.homeText),
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .padding(top = 15.dp)
                                    .padding(bottom = 26.dp)
                                    .size(95.dp, 35.dp)
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                colorResource(R.color.buttonGrStart),
                                                colorResource(R.color.buttonGrEnd)
                                            )
                                        ),
                                        shape = RoundedCornerShape(50.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Больше",
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(600),
                                    fontFamily = montserratBold
                                )
                            }
                        }
                        Image(painter = painterResource(R.drawable.moon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 3.dp))
                    }
                }
                Text(text = "Ваше расписание",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = montserratBold,
                    modifier = Modifier
                        .padding(top = 30.dp)
                )
                LazyRow(modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()) {
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Пон",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                               )
                                Text(text = "11",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Вто",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "12",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Сре",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "13",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Чет",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "14",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Пят",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "15",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Суб",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "16",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .padding(end = 15.dp)
                            .size(60.dp, 80.dp)
                            .background(color = colorResource(R.color.tfColor),
                                shape = RoundedCornerShape(10.dp))){
                            Column(modifier = Modifier.padding(top = 15.dp)
                                .fillMaxWidth()) {
                                Text(text = "Вос",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(text = "17",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
                LazyColumn(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()) {
                    item {
                        ElevatedCard(
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                                .background(color = colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(20.dp))
                        ) {
                            Column(modifier = Modifier
                                .padding(top = 15.dp)
                                .padding(horizontal = 15.dp)
                                .padding(bottom = 20.dp)
                                .fillMaxWidth()) {
                                Box(modifier = Modifier
                                    .fillMaxWidth()) {
                                    Icon(
                                        painter = painterResource(R.drawable.more_icon),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                    )
                                }
                                Row(modifier = Modifier
                                    .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Image(painter = painterResource(R.drawable.bed_icon),
                                        contentDescription = null)
                                    Column(modifier = Modifier
                                        .padding(start = 15.dp)) {
                                        Text(text = state.name,
                                            color = Color.Black,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular,
                                            fontSize = 14.sp
                                        )
                                        Text(text = state.hours,
                                            color = colorResource(R.color.onBText),
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier
                                                .padding(top = 5.dp))
                                    }
                                    Box(modifier = Modifier
                                        .fillMaxWidth()){
                                        Switch(checked = true,
                                            onCheckedChange = null,
                                            modifier = Modifier.align(Alignment.BottomEnd))
                                    }
                                }
                            }
                        }
                        ElevatedCard(
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 10.dp
                            ),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                                .background(color = colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(20.dp))
                        ) {
                            Column(modifier = Modifier
                                .padding(top = 15.dp)
                                .padding(horizontal = 15.dp)
                                .padding(bottom = 20.dp)
                                .fillMaxWidth()) {
                                Box(modifier = Modifier
                                    .fillMaxWidth()) {
                                    Icon(
                                        painter = painterResource(R.drawable.more_icon),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                    )
                                }
                                Row(modifier = Modifier
                                    .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Image(painter = painterResource(R.drawable.clock_icon),
                                        contentDescription = null)
                                    Column(modifier = Modifier
                                        .padding(start = 15.dp)) {
                                        Text(text = state.name,
                                            color = Color.Black,
                                            fontWeight = FontWeight(500),
                                            fontFamily = montserratRegular,
                                            fontSize = 14.sp
                                        )
                                        Text(text = state.hours,
                                            color = colorResource(R.color.onBText),
                                            fontSize = 14.sp,
                                            fontFamily = montserratRegular,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier
                                                .padding(top = 5.dp))
                                    }
                                    Box(modifier = Modifier
                                        .fillMaxWidth()){
                                        Switch(checked = true,
                                            onCheckedChange = null,
                                            modifier = Modifier.align(Alignment.BottomEnd))
                                    }
                                }
                            }
                        }
                        Box(modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .background(Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.buttonGrStart),
                                    colorResource(R.color.buttonGrEnd)
                                )
                            ),
                                shape = RoundedCornerShape(20.dp),
                                alpha = 0.2f)){
                            Column(modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()) {
                                Text(text = "Сегодня вечером у тебя\nбудет 8 часов 10 минут.",
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular
                               )
                                Image(painter = painterResource(R.drawable.progressbar),
                                    contentDescription = null,
                                    modifier = Modifier
                                    .padding(top = 11.dp)
                                    .fillMaxWidth(),
                                    contentScale = ContentScale.Crop)
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier
                            .height(100.dp))
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd) {
            IconButton(
                onClick = {
                    navController.navigate(NavRoutes.AddAlarm.route)
                },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .padding(end = 30.dp)
                    .size(60.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.buttonGrStart),
                                colorResource(R.color.buttonGrEnd)
                            )
                        ),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.plus),
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
        if (state.error.isNotEmpty() &&
            state.error != "List is empty."){
            ErrorAlertDialog(state.error) {
                vm.onEvent(SleepScheduleEvent.ClearError)
            }
        }
    }
}