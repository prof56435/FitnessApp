package com.example.fitnessapp.feature_app.presentation.SleepTracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.yml.charts.common.extensions.isNotNull
import coil.util.CoilUtils
import com.example.fitnessapp.NavRoutes
import com.example.fitnessapp.R
import com.example.fitnessapp.feature_app.presentation.SleepSchedule.SleepScheduleEvent
import com.example.fitnessapp.feature_app.presentation.SleepSchedule.SleepScheduleScreen
import com.example.fitnessapp.feature_app.presentation.common.ErrorAlertDialog
import com.example.fitnessapp.feature_app.presentation.common.TopAppBar
import com.example.fitnessapp.feature_app.presentation.common.montserratBold
import com.example.fitnessapp.feature_app.presentation.common.montserratRegular
import org.koin.androidx.compose.koinViewModel


@Composable
fun SleepTrackerScreen(navController: NavController, vm: SleepTrackerVM = koinViewModel()) {
    val state = vm.state.value
    vm.onEvent(SleepTrackerEvent.GetSleep)
    Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 30.dp)) {
                TopAppBar("Трекер сна", navController)
                Image(painter = painterResource(R.drawable.sleeptrack),
                    contentDescription = null,
                    Modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                ElevatedCard(modifier = Modifier
                    .padding(top = 14.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(color = colorResource(R.color.shadowColor).copy(alpha = 0.4f),
                        shape = RoundedCornerShape(8.dp)),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        contentColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)){
                    Text(text = "Увеличено на 43% ",
                        color = colorResource(R.color.loginColor),
                        fontFamily = montserratRegular,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Box(modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .background(Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.buttonGrEnd),
                            colorResource(R.color.buttonGrStart)
                        )
                    ),
                        shape = RoundedCornerShape(22.dp))
                    .clickable {
                        navController.navigate(NavRoutes.SleepSchedule.route)
                    }){
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)) {
                        Text(text = "Последний сон",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(start = 20.dp)
                       )
                        Text(text = "8ч 20м",
                            color = Color.White,
                            fontFamily = montserratRegular,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            modifier = Modifier
                            .padding(top = 5.dp)
                                .padding(start = 20.dp)
                        )
                        Image(painter = painterResource(R.drawable.sleep_graph_sleep),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop)
                    }
                }
                Box(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .background(Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(R.color.buttonGrEnd),
                            colorResource(R.color.buttonGrStart)
                        )
                    ),
                        shape = RoundedCornerShape(100.dp),
                        alpha = 0.2f)){
                    Row(modifier = Modifier
                        .padding(top = 15.dp)
                        .padding(bottom = 14.dp)
                        .padding(start = 20.dp)
                        .padding(end = 14.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Трафик сна",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = montserratRegular
                       )
                        Box(modifier = Modifier
                            .size(96.dp, 28.dp)
                            .background(Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(R.color.buttonGrStart),
                                    colorResource(R.color.buttonGrEnd)
                                )
                            ),
                                shape = RoundedCornerShape(100.dp)),
                            contentAlignment = Alignment.Center){
                            Text(text = "Проверить",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = montserratRegular
                           )
                        }
                    }
                }
                LazyColumn(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()) {
                    item {
                        Text(text = "Расписание на сегодня",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = montserratBold,
                            fontWeight = FontWeight(600))
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
                    }
                    item {
                        Box(modifier = Modifier
                            .height(100.dp))
                    }
                }
            }
        }
        if (state.error.isNotEmpty() &&
            state.error != "List is empty."){
            ErrorAlertDialog(state.error) {
                vm.onEvent(SleepTrackerEvent.ClearError)
            }
        }
    }
}